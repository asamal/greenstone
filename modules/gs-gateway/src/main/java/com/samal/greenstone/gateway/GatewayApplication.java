package com.samal.greenstone.gateway;

import com.samal.greenstone.gateway.config.ModulesConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

@EnableWebFlux
@EnableWebFluxSecurity
@EnableConfigurationProperties(ModulesConfiguration.class)
@SpringBootApplication
@RestController
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }


    @GetMapping("/error")
    public Mono<String> error(ServerHttpRequest request) {
        return Mono.just("E-R-R-O-R");
    }


    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder, ModulesConfiguration modulesConfiguration) {
        return builder.routes()
                .route(p -> p
                        .path("/trees/**", "/clients/**")
                        .filters(getHelloWorldFilter())
                        .uri(modulesConfiguration.getCoreUrl()))
                .route(p -> p
                        .path("/customers/**")
                        .filters(getHelloWorldFilter())
                        .uri(modulesConfiguration.getGsUserUrl()))
                .route(p -> p
                        .path("/hello/**")
                        .filters(getHelloWorldFilter())
                        .uri(modulesConfiguration.getGsUserQUrl()))
                .build();
    }

    private Function<GatewayFilterSpec, UriSpec> getHelloWorldFilter() {
        return f -> f.addRequestHeader("Hello", "World");
    }


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http.authorizeExchange()
                .pathMatchers("/", "/error", "/webjars/**").permitAll()
                .pathMatchers("/customers", "/customers/**").permitAll()
                .pathMatchers("/clients", "/clients/**").permitAll()
                .pathMatchers("/hello", "/hello/**").permitAll()
                .pathMatchers("/trees", "/trees/**").permitAll()
                .anyExchange().authenticated()
                .and().csrf().csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse())
                .and().logout()
                .and().oauth2Login().and().build();
    }
}
