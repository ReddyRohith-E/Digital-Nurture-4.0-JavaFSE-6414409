package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Main Spring Boot Application class
 * This class bootstraps the Spring Boot application and imports XML configuration
 */
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class SpringLearnApplication {

    /**
     * Main method to start the Spring Boot application
     * The application will run on port 8083 (configured in application.properties)
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        System.out.println("Spring Boot Application Started!");
        System.out.println("Access the REST service at: http://localhost:8083/country");
    }
}
