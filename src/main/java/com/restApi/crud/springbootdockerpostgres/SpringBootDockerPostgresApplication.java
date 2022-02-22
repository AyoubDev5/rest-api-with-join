package com.restApi.crud.springbootdockerpostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.example.something", "com.example.application"})
public class SpringBootDockerPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerPostgresApplication.class, args);
	}

}
