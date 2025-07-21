package com.example.springrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestDemoApplication.class, args);
		System.out.println("Spring Boot REST Application Started Successfully!");
		System.out.println("Access the application at: http://localhost:8080");
		System.out.println("API Base URL: http://localhost:8080/api/employees");
	}

}
