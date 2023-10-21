package edu.diosantander.lab;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Clientes - Rest API",
		version = "1.0",
		description = "Exemplos de padrões de projeto com uso de Springboot REST API",
		termsOfService = "Termo de uso: Open Source",
		contact = @Contact (name = "Aline Mizumukai", url = "https://www.linkedin.com/in/alinemizumukai/")
))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
