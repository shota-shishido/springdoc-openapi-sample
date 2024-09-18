package com.example.demo

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition(
	info = Info(
		title = "Springdoc-openapi sample",
		version = "1.0",
		description = "Springdoc-openapiのサンプルです",
	)
)
@SpringBootApplication
class SpringdocOpenapiSampleApplication

fun main(args: Array<String>) {
	runApplication<SpringdocOpenapiSampleApplication>(*args)
}
