package com.cognizant.ormlearn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Application Configuration Class
 * Enables JPA repositories and transaction management
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.cognizant.ormlearn.repository")
@EnableTransactionManagement
public class ApplicationConfig {
    // This class can be used to define additional beans or configurations
    // related to the application context if needed in the future.
}
