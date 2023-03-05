package com.chatvision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class ChatVisionSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatVisionSecurityApplication.class, args);
	}

}
