package com.cognizant.ormlearn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

/**
 * REST Controller for Country operations
 */
@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * Get all countries
     */
    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    /**
     * Get country by code
     */
    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        return countryService.getCountryByCode(code).orElse(null);
    }

    /**
     * Add a new country
     */
    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryService.saveCountry(country);
    }

    /**
     * Search countries by name pattern
     */
    @GetMapping("/search/{pattern}")
    public List<Country> searchCountries(@PathVariable String pattern) {
        return countryService.getCountriesByNamePattern(pattern);
    }

    /**
     * Get total count
     */
    @GetMapping("/count")
    public long getCount() {
        return countryService.getCountryCount();
    }
}
