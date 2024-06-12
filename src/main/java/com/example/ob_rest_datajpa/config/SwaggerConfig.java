package com.example.ob_rest_datajpa.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;


import java.util.Collections;


//http://localhost:8080/doc/swagger-ui
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot Book API Rest")
                        .version("v1.0")
                        .description("SpringShop Wiki Documentation")
                        .termsOfService("http://localhost:8080/swagger-ui/")
                        .license(new License().name("Apache").url("http://localhost:8080/swagger-ui/")));
    }


}
