package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for Country operations
 */
@RestController
public class CountryController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/country")
    public Country getCountryIndia() {
        // Load India bean from Spring XML configuration
        Country country = (Country) applicationContext.getBean("country");
        return country;
    }
}
