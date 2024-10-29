package com.koisystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Koi System API")
                        .description("API documentation for Koi Fish Management System")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Your Name")
                                .email("email@example.com")
                                .url("www.example.com"))
                        .license(new License()
                                .name("License of API")
                                .url("API license URL")))
                .schemaRequirement("basicAuth", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("basic"));
    }
}
