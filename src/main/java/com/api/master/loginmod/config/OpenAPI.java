package com.api.master.loginmod.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenAPI {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("springlogin-public")
                .pathsToMatch("/register")
                .build();
    }
    @Bean
    public io.swagger.v3.oas.models.OpenAPI springShopOpenAPI() {
        return new io.swagger.v3.oas.models.OpenAPI()
                .info(new Info().title("Spring Login/Register API")
                        .description("Spring login and register sample application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Spring Login Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }


}