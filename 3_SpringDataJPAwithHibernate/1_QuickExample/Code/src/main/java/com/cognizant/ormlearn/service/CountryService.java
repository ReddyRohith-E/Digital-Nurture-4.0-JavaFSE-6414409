package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

/**
 * Service class for Country operations
 * Contains business logic for country-related operations
 */
@Service
@Transactional
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    /**
     * Retrieve all countries from the database
     * 
     * @return List of all countries
     */
    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        LOGGER.info("Fetching all countries from database");
        List<Country> countries = countryRepository.findAll();
        LOGGER.info("Found {} countries", countries.size());
        return countries;
    }

    /**
     * Find a country by its code
     * 
     * @param code the country code
     * @return Optional containing the country if found
     */
    @Transactional(readOnly = true)
    public Optional<Country> getCountryByCode(String code) {
        LOGGER.info("Searching for country with code: {}", code);
        Optional<Country> country = countryRepository.findById(code);
        if (country.isPresent()) {
            LOGGER.info("Found country: {}", country.get());
        } else {
            LOGGER.warn("No country found with code: {}", code);
        }
        return country;
    }

    /**
     * Find countries by name pattern (case insensitive)
     * 
     * @param namePattern the name pattern to search for
     * @return List of countries matching the pattern
     */
    @Transactional(readOnly = true)
    public List<Country> getCountriesByNamePattern(String namePattern) {
        LOGGER.info("Searching for countries with name pattern: {}", namePattern);
        List<Country> countries = countryRepository.findByNameContainingIgnoreCase(namePattern);
        LOGGER.info("Found {} countries matching pattern '{}'", countries.size(), namePattern);
        return countries;
    }

    /**
     * Save a new country or update an existing one
     * 
     * @param country the country to save
     * @return the saved country
     */
    public Country saveCountry(Country country) {
        LOGGER.info("Saving country: {}", country);
        try {
            Country savedCountry = countryRepository.save(country);
            LOGGER.info("Successfully saved country with code: {}", savedCountry.getCode());
            return savedCountry;
        } catch (Exception e) {
            LOGGER.error("Error saving country: {}", country, e);
            throw new RuntimeException("Failed to save country", e);
        }
    }

    /**
     * Delete a country by its code
     * 
     * @param code the country code
     * @return true if country was deleted, false if not found
     */
    public boolean deleteCountryByCode(String code) {
        LOGGER.info("Attempting to delete country with code: {}", code);
        if (countryRepository.existsById(code)) {
            countryRepository.deleteById(code);
            LOGGER.info("Successfully deleted country with code: {}", code);
            return true;
        } else {
            LOGGER.warn("Cannot delete - no country found with code: {}", code);
            return false;
        }
    }

    /**
     * Check if a country exists by code
     * 
     * @param code the country code
     * @return true if country exists, false otherwise
     */
    @Transactional(readOnly = true)
    public boolean countryExists(String code) {
        LOGGER.debug("Checking if country exists with code: {}", code);
        return countryRepository.existsById(code);
    }

    /**
     * Get the total count of countries
     * 
     * @return total number of countries
     */
    @Transactional(readOnly = true)
    public long getCountryCount() {
        long count = countryRepository.count();
        LOGGER.info("Total countries in database: {}", count);
        return count;
    }
}
