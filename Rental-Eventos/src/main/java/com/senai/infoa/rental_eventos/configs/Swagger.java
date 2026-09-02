package com.senai.infoa.rental_eventos.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "RENTAL-EVENTOS", version = "1.0", description = "Sistema de aluguel de equipamentos para eventos e festas"))

public class Swagger {
}