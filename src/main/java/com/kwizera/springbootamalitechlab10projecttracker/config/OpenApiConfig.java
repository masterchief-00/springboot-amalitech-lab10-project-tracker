package com.kwizera.springbootamalitechlab10projecttracker.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Project Tracker REST API")
                .description("API Documentation for a project tracker rest api.")
                .version("1.0.0"));
    }
}
