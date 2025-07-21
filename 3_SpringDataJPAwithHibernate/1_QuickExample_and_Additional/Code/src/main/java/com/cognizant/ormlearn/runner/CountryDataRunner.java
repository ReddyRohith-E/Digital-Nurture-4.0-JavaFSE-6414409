package com.cognizant.ormlearn.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

/**
 * Command Line Runner to demonstrate Country operations
 * Runs automatically when the application starts
 */
@Component
public class CountryDataRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryDataRunner.class);

    private final CountryService countryService;

    public CountryDataRunner(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("=== Starting Country Data Demo ===");
        
        try {
            // Display all countries
            displayAllCountries();
            
            // Search for specific country
            searchCountryByCode("IN");
            
            // Search for countries by name pattern
            searchCountriesByNamePattern("United");
            
            // Display total count
            displayCountryCount();
            
        } catch (Exception e) {
            LOGGER.error("Error during country data demo", e);
        }
        
        LOGGER.info("=== Country Data Demo Completed ===");
    }

    private void displayAllCountries() {
        LOGGER.info("--- Displaying All Countries ---");
        List<Country> countries = countryService.getAllCountries();
        
        if (countries.isEmpty()) {
            LOGGER.warn("No countries found in the database");
        } else {
            countries.forEach(country -> 
                LOGGER.info("Country: {} - {}", country.getCode(), country.getName())
            );
        }
    }

    private void searchCountryByCode(String code) {
        LOGGER.info("--- Searching for Country with Code: {} ---", code);
        countryService.getCountryByCode(code)
            .ifPresentOrElse(
                country -> LOGGER.info("Found: {}", country),
                () -> LOGGER.warn("Country with code '{}' not found", code)
            );
    }

    private void searchCountriesByNamePattern(String pattern) {
        LOGGER.info("--- Searching for Countries with Name Pattern: {} ---", pattern);
        List<Country> countries = countryService.getCountriesByNamePattern(pattern);
        
        if (countries.isEmpty()) {
            LOGGER.warn("No countries found matching pattern '{}'", pattern);
        } else {
            countries.forEach(country -> 
                LOGGER.info("Match: {} - {}", country.getCode(), country.getName())
            );
        }
    }

    private void displayCountryCount() {
        long count = countryService.getCountryCount();
        LOGGER.info("--- Total Countries in Database: {} ---", count);
    }
}
