package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.CountryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for OrmLearn Application
 * Tests the Country entity, repository, and service layers
 * 
 * @author Cognizant
 * @version 1.0
 */
@SpringBootTest
@TestPropertySource(properties = {
    "spring.jpa.hibernate.ddl-auto=validate",
    "logging.level.org.hibernate.SQL=debug"
})
@TestMethodOrder(MethodOrderer.DisplayName.class)
class OrmLearnApplicationTests {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryRepository countryRepository;

    @Test
    @DisplayName("Test 1: Get All Countries - Should Return Non-Empty List")
    void testGetAllCountries() {
        // When
        List<Country> countries = countryService.getAllCountries();
        
        // Then
        assertNotNull(countries, "Country list should not be null");
        assertFalse(countries.isEmpty(), "Country list should not be empty");
        assertTrue(countries.size() >= 4, "There should be at least 4 countries in the database");
        
        // Log for verification
        System.out.println("Total countries found: " + countries.size());
        countries.forEach(System.out::println);
    }

    @Test
    @DisplayName("Test 2: Find Country By Code - India")
    void testFindCountryByCodeIndia() {
        // When
        Optional<Country> countryOpt = countryService.getCountryByCode("IN");
        
        // Then
        assertTrue(countryOpt.isPresent(), "Country with code 'IN' should exist");
        
        Country country = countryOpt.get();
        assertEquals("IN", country.getCode(), "Country code should be 'IN'");
        assertEquals("India", country.getName(), "Country name should be 'India'");
        
        System.out.println("Found country: " + country);
    }

    @Test
    @DisplayName("Test 3: Find Country By Code - United States")
    void testFindCountryByCodeUS() {
        // When
        Optional<Country> countryOpt = countryRepository.findById("US");
        
        // Then
        assertTrue(countryOpt.isPresent(), "Country with code 'US' should exist");
        
        Country country = countryOpt.get();
        assertEquals("US", country.getCode(), "Country code should be 'US'");
        assertEquals("United States of America", country.getName(), 
                    "Country name should be 'United States of America'");
    }

    @Test
    @DisplayName("Test 4: Find Country By Invalid Code")
    void testFindCountryByInvalidCode() {
        // When
        Optional<Country> countryOpt = countryService.getCountryByCode("XX");
        
        // Then
        assertFalse(countryOpt.isPresent(), "Country with code 'XX' should not exist");
    }

    @Test
    @DisplayName("Test 5: Search Countries By Name Pattern")
    void testSearchCountriesByNamePattern() {
        // When
        List<Country> countries = countryService.getCountriesByNamePattern("United");
        
        // Then
        assertNotNull(countries, "Result list should not be null");
        assertFalse(countries.isEmpty(), "Should find countries with 'United' in name");
        
        // Verify all results contain "United" (case insensitive)
        countries.forEach(country -> 
            assertTrue(country.getName().toLowerCase().contains("united"), 
                      "Country name should contain 'United': " + country.getName())
        );
        
        System.out.println("Countries containing 'United':");
        countries.forEach(System.out::println);
    }

    @Test
    @DisplayName("Test 6: Country Exists Check")
    void testCountryExists() {
        // Test existing country
        assertTrue(countryService.countryExists("IN"), "India should exist");
        assertTrue(countryService.countryExists("US"), "USA should exist");
        
        // Test non-existing country
        assertFalse(countryService.countryExists("XX"), "Country XX should not exist");
    }

    @Test
    @DisplayName("Test 7: Get Country Count")
    void testGetCountryCount() {
        // When
        long count = countryService.getCountryCount();
        
        // Then
        assertTrue(count >= 4, "Should have at least 4 countries");
        
        // Verify consistency with getAllCountries
        List<Country> allCountries = countryService.getAllCountries();
        assertEquals(allCountries.size(), count, 
                    "Count should match the size of getAllCountries()");
        
        System.out.println("Total country count: " + count);
    }

    @Test
    @DisplayName("Test 8: Repository Custom Methods")
    void testRepositoryCustomMethods() {
        // Test findByNameContainingIgnoreCase
        List<Country> countries = countryRepository.findByNameContainingIgnoreCase("america");
        assertFalse(countries.isEmpty(), "Should find countries with 'america' in name");
        
        // Test countByNameContainingIgnoreCase
        long count = countryRepository.countByNameContainingIgnoreCase("a");
        assertTrue(count > 0, "Should find countries with 'a' in name");
        
        // Test existsByCode
        assertTrue(countryRepository.existsByCode("IN"), "India should exist by code");
        assertFalse(countryRepository.existsByCode("ZZ"), "ZZ should not exist");
        
        System.out.println("Countries with 'america' in name: " + countries.size());
        System.out.println("Countries with 'a' in name: " + count);
    }
}
