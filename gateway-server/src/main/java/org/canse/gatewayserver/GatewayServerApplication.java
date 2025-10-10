package org.canse.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }


//     Ceci permet d'effectuer une requete sur
//    -http://localhost:8888/api/departments/MK

//    plutot que sur :
//    - http://localhost:8888/DEPARTMENT-MICROSERVICE/api/departments/MK

    @Bean
    public RouteLocator MyRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/api/departments/**")
                        .uri("lb://DEPARTMENT-MICROSERVICE")
                )
                .route(p -> p
                        .path("/api/teachers/**")
                        .uri("lb://TEACHER-MICROSERVICE")
                )
                .build();
    }

}
