package com.aztec.apigateway.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("resource-server", r -> r.path("/resource-server/**")
                        .uri("lb://resource-server"))
                .route("auth-server", r -> r.path("/auth-server/**")
                        .uri("http://localhost:8085"))
                .build();
    }
}
