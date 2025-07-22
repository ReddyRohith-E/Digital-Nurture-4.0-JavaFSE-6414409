package com.cognizant.springlearn.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;

/**
 * Service class for Country operations
 */
@Service
public class CountryService {
    
    private Map<String, Country> countryData;
    
    public CountryService() {
        initializeCountryData();
    }
    
    /**
     * Initialize country data with some sample countries including India
     */
    private void initializeCountryData() {
        countryData = new HashMap<>();
        
        // India country details
        Country india = new Country("IN", "India", "New Delhi", 
                                  1380004385L, "Indian Rupee (INR)", 
                                  "Asia", "Southern Asia", 3287263.0);
        countryData.put("IN", india);
        
        // Add a few more countries for testing
        Country usa = new Country("US", "United States of America", "Washington, D.C.", 
                                331002651L, "US Dollar (USD)", 
                                "Americas", "Northern America", 9833517.0);
        countryData.put("US", usa);
        
        Country uk = new Country("UK", "United Kingdom", "London", 
                               67886011L, "British Pound (GBP)", 
                               "Europe", "Northern Europe", 243610.0);
        countryData.put("GB", uk);
    }
    
    /**
     * Get country details by country code
     * @param countryCode the country code (e.g., "IN" for India)
     * @return Country object or null if not found
     */
    public Country getCountryByCode(String countryCode) {
        return countryData.get(countryCode.toUpperCase());
    }

    public Country notFoundCountry() {
        return null; // Return null if country not found
    }

    public Country getIndiaCountryDetails() {
        return countryData.get("IN"); 
    }
}
