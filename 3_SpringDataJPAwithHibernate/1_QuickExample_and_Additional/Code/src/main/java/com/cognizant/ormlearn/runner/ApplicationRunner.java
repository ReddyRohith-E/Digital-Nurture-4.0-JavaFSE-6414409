package com.cognizant.ormlearn.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DatabaseConnectionService;

/**
 * Application Runner that demonstrates database connectivity and basic operations
 */
@Component
@Order(2) // Run after DatabaseConnectionService
public class ApplicationRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationRunner.class);

    private final CountryService countryService;
    private final DatabaseConnectionService connectionService;

    public ApplicationRunner(CountryService countryService, DatabaseConnectionService connectionService) {
        this.countryService = countryService;
        this.connectionService = connectionService;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("=== ORM Learn Application Started ===");
        
        try {
            // Display connection info
            LOGGER.info("Connection Pool Status: {}", connectionService.getConnectionPoolInfo());
            
            // Test basic database operations
            demonstrateOperations();
            
        } catch (Exception e) {
            LOGGER.error("❌ Error during application startup: {}", e.getMessage(), e);
        }
        
        LOGGER.info("=== Application Ready ===");
    }

    /**
     * Demonstrate basic database operations
     */
    private void demonstrateOperations() {
        LOGGER.info("--- Demonstrating Database Operations ---");
        
        try {
            // 1. Get all countries
            List<Country> countries = countryService.getAllCountries();
            LOGGER.info("✅ Found {} countries in database", countries.size());
            
            if (!countries.isEmpty()) {
                LOGGER.info("Sample countries:");
                countries.stream()
                    .limit(5)
                    .forEach(country -> LOGGER.info("  - {}: {}", country.getCode(), country.getName()));
            }
            
            // 2. Test find by code
            countryService.getCountryByCode("IN")
                .ifPresentOrElse(
                    country -> LOGGER.info("✅ Found India: {}", country),
                    () -> LOGGER.info("ℹ️ India not found in database")
                );
            
            // 3. Test search functionality
            List<Country> searchResults = countryService.getCountriesByNamePattern("United");
            LOGGER.info("✅ Found {} countries containing 'United'", searchResults.size());
            
            // 4. Count total countries
            long totalCount = countryService.getCountryCount();
            LOGGER.info("✅ Total countries in database: {}", totalCount);
            
        } catch (Exception e) {
            LOGGER.error("❌ Error during database operations: {}", e.getMessage());
            LOGGER.info("💡 This might indicate a connection or configuration issue");
        }
    }
}
