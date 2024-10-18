package com.e_commerce.e_commerce_system.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Manish Nilkanth",
                        email = "nilkanthmanish0@gmail.com",
                        url = "https://nilkanthportfolio.netlify.app/"
                ),
                description = "OpenApi documentation for E-Commerce System APIs for Spring Boot Application",
                title = "E-Commerce System Application : Back-end API's and configurations",
                version = "1.0",
                license = @License(
                        name = "Apache",
                        url = "https://apache.com"
                ),
                termsOfService = "Free to use"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )

        }
)
@Configuration
public class OpenApiConfig {

}

