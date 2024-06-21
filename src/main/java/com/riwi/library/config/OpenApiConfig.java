package com.riwi.library.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/***Swagger configuration*/
@Configuration
@OpenAPIDefinition(info = @Info(title = "Api for online library management LibrosYa", version = "1.0", description = "Develop an online library management system to efficiently store and manage books, users, loans, and reserves."))
public class OpenApiConfig {
}
