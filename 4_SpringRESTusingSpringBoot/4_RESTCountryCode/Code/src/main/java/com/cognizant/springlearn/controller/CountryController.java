package com.cognizant.springlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;

/**
 * REST Controller for Country operations
 * This controller handles HTTP requests related to country information
 */
@RestController
public class CountryController {
    
    @Autowired
    private CountryService countryService;
    
  
    @RequestMapping(value = "/country", method = RequestMethod.GET, 
                   produces = "application/json")
    public ResponseEntity<Country> getCountryById(
            @RequestParam(value = "code", required = false, defaultValue = "IN") String countryCode) {
        
        Country country;

        if (countryCode == null || countryCode.isEmpty() || "IN".equalsIgnoreCase(countryCode)) {
            // If no code provided or code is "IN", return India details
            country = countryService.getIndiaCountryDetails();
        } else {
            // Get country by provided code
            country = countryService.getCountryByCode(countryCode);
        }

        if (country != null) {
            // Return country data with HTTP 200 OK status
            return new ResponseEntity<>(country, HttpStatus.OK);
        } else {
            // Return HTTP 404 Not Found if country not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     * Alternative endpoint specifically for India
     * URL: /country/india
     */
    @RequestMapping(value = "/country/india", method = RequestMethod.GET, 
                   produces = "application/json")
    public ResponseEntity<Country> getIndiaCountry() {
        Country india = countryService.getIndiaCountryDetails();
        return new ResponseEntity<>(india, HttpStatus.OK);
    }
}
