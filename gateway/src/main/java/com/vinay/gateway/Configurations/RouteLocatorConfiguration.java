package com.vinay.gateway.Configurations;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfiguration {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/**")
                        .uri("lb://authoriser-server")
                )
                .route(p -> p
                        .path("/**")
                        .uri("lb://websocket-server")
                )
                .build();
    }
}
