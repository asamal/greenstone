package com.samal.greenstone.gateway;

import com.samal.greenstone.gateway.config.UriConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@EnableConfigurationProperties(UriConfiguration.class)
@SpringBootApplication
@RestController
public class GatewayApplication /*extends WebSecurityConfigurerAdapter*/  {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

//    @GetMapping("/user")
//    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
//        return Collections.singletonMap("name", principal.getAttribute("name"));
//    }


//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//            registry.addResourceHandler("/webjars/**")
//                    .addResourceLocations("/webjars/")
//                    .resourceChain(false);
//            registry.setOrder(1);
//    }
//
//    @GetMapping("/error")
//    @ResponseBody
//    public String error(HttpServletRequest request) {
//        String message = (String) request.getSession().getAttribute("error.message");
//        request.getSession().removeAttribute("error.message");
//        return message;
//    }

//    @Bean
//    public ServerCodecConfigurer serverCodecConfigurer() {
//        return ServerCodecConfigurer.create();
//    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/customers")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://localhost:8082"))

                .build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        SimpleUrlAuthenticationFailureHandler handler = new SimpleUrlAuthenticationFailureHandler("/");
//        // @formatter:off
//        http
//                .authorizeRequests(a -> a
//                        .antMatchers("/**").permitAll()
//                        .anyRequest().anonymous()
//                );
//        // @formatter:on
//    }

}
