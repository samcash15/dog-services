package com.cashion.dog.dogservices.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("dogbreed")
                .pathsToMatch("/api/v1/dogbreed/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Dog Breed API").version("1.0").description("Documentation Dog Breed API v1.0"))
                .addSecurityItem(new SecurityRequirement().addList("X-API-KEY"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("X-API-KEY",
                                new SecurityScheme()
                                        .name("X-API-KEY")
                                        .type(SecurityScheme.Type.APIKEY)
                                        .in(SecurityScheme.In.HEADER)));
    }
}
