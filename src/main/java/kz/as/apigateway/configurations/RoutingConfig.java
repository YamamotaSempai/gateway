package kz.as.apigateway.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {

    private final AuthenticationFilter authenticationFilter;

    @Autowired
    public RoutingConfig(AuthenticationFilter authenticationFilter) {
        this.authenticationFilter = authenticationFilter;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-route", r -> r
                        .path("/auth-service/**")
                        .filters(f -> {
                            f = f.stripPrefix(1);
                            f.filter(authenticationFilter);
                            return f;
                        })
                        .uri("lb://auth-service/")
                )
                .route("baza-route", r -> r
                        .path("/baza-service/**")
                        .filters(f -> {
                            f = f.stripPrefix(1);
                            f.filter(authenticationFilter);
                            return f;
                        })
                        .uri("lb://baza-service/")
                )
                .build();
    }
}
