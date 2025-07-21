package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Country entity
 * These tests don't require Spring context
 * 
 * @author Cognizant
 * @version 1.0
 */
class CountryUnitTest {

    @Test
    @DisplayName("Test Country Entity Creation")
    void testCountryCreation() {
        // Test default constructor
        Country country1 = new Country();
        assertNotNull(country1);

        // Test parameterized constructor
        Country country2 = new Country("IN", "India");
        assertEquals("IN", country2.getCode());
        assertEquals("India", country2.getName());
    }

    @Test
    @DisplayName("Test Country Getters and Setters")
    void testCountryGettersAndSetters() {
        Country country = new Country();
        
        // Test setters
        country.setCode("US");
        country.setName("United States");
        
        // Test getters
        assertEquals("US", country.getCode());
        assertEquals("United States", country.getName());
    }

    @Test
    @DisplayName("Test Country Equality and HashCode")
    void testCountryEquality() {
        // Create test countries
        Country country1 = new Country("TEST", "Test Country");
        Country country2 = new Country("TEST", "Different Name"); // Same code, different name
        Country country3 = new Country("DIFFERENT", "Test Country");
        Country country4 = new Country(null, "Null Code");
        Country country5 = new Country(null, "Another Null Code");

        // Test equality (based on code)
        assertEquals(country1, country2, "Countries with same code should be equal");
        assertNotEquals(country1, country3, "Countries with different codes should not be equal");
        assertEquals(country4, country5, "Countries with null codes should be equal");
        
        // Test reflexivity
        assertEquals(country1, country1, "Country should be equal to itself");
        
        // Test symmetry
        assertEquals(country2, country1, "Equality should be symmetric");
        
        // Test hashCode consistency
        assertEquals(country1.hashCode(), country2.hashCode(), 
                    "Equal countries should have same hashCode");
        
        // Test with null
        assertNotEquals(country1, null, "Country should not be equal to null");
        assertNotEquals(country1, "NotACountry", "Country should not be equal to different type");
    }

    @Test
    @DisplayName("Test Country toString")
    void testCountryToString() {
        Country country = new Country("US", "United States");
        String toString = country.toString();
        
        assertNotNull(toString, "toString should not return null");
        assertTrue(toString.contains("US"), "toString should contain code");
        assertTrue(toString.contains("United States"), "toString should contain name");
        assertTrue(toString.contains("Country"), "toString should contain class name");
    }

    @Test
    @DisplayName("Test Country with Null Values")
    void testCountryWithNullValues() {
        Country country = new Country(null, null);
        
        assertNull(country.getCode());
        assertNull(country.getName());
        
        // Test toString with nulls
        assertNotNull(country.toString());
        
        // Test hashCode with null code
        assertDoesNotThrow(() -> country.hashCode());
    }
}
