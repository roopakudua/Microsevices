package com.example.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan({"com.example.database.data"})
public class ConsumeBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumeBasicApplication.class, args);
	}
	@Bean

	RestTemplate restTemplate() {

		return new RestTemplate();

	}
}
