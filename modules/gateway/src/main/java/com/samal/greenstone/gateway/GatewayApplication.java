package com.samal.greenstone.gateway;

import com.samal.greenstone.gateway.config.UriConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;
import org.springframework.security.web.server.csrf.ServerCsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import wiremock.javax.servlet.http.HttpServletRequest;

import java.util.Collections;
import java.util.Map;

@EnableWebSecurity
@EnableConfigurationProperties(UriConfiguration.class)
@SpringBootApplication
@RestController
public class GatewayApplication /*extends WebSecurityConfigurerAdapter*/ {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }


    @GetMapping("/error")
//    @ResponseBody
    public Mono<String> error(ServerHttpRequest request) {
//        String message = request.toString();
//        String message = (String) request.getSession().getAttribute("error.message");
//        request.getSession().removeAttribute("error.message");
        return Mono.empty();
    }


    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/customers/**")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://localhost:8082"))

                .build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        http
                // ...
                .authorizeExchange()
                // any URL that starts with /admin/ requires the role "ROLE_ADMIN"
                .pathMatchers("/", "/error", "/webjars/**", "/customers", "/customers/**", "/logout").permitAll()
//                .pathMatchers("/admin/**").hasRole("ADMIN")
//                // a POST to /users requires the role "USER_POST"
//                .pathMatchers(HttpMethod.POST, "/users").hasAuthority("USER_POST")
//                // a request to /users/{username} requires the current authentication's username
//                // to be equal to the {username}
//                .pathMatchers("/users/{username}").access((authentication, context) ->
//                authentication
//                        .map(Authentication::getName)
//                        .map((username) -> username.equals(context.getVariables().get("username")))
//                        .map(AuthorizationDecision::new)
//        )
//                // allows providing a custom matching strategy that requires the role "ROLE_CUSTOM"
////                .matchers(customMatcher).hasRole("CUSTOM")
//                // any other request requires the user to be authenticated
                .anyExchange().authenticated()
                .and().csrf().csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse())
                .and().logout()
                .and().oauth2Login();
        return http.build();

//        return http.authorizeExchange()
//                .anyExchange().authenticated()
//                .and().build();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        SimpleUrlAuthenticationFailureHandler handler = new SimpleUrlAuthenticationFailureHandler("/");
//        // @formatter:off
//        http
//                .authorizeRequests(a -> a
//                        .antMatchers("/", "/error", "/webjars/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .exceptionHandling(e -> e
//                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                )
//                .oauth2Login();
//        // @formatter:on
//    }

}
