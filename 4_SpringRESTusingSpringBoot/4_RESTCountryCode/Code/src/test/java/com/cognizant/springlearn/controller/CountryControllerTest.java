package com.cognizant.springlearn.controller;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;

@WebMvcTest(CountryController.class)
public class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    @Test
    public void testGetIndiaCountryDetails() throws Exception {
        // Mock India country data
        Country india = new Country("IN", "India", "New Delhi", 
                                  1380004385L, "Indian Rupee (INR)", 
                                  "Asia", "Southern Asia", 3287263.0);
        
        when(countryService.getCountryByCode("IN")).thenReturn(india);

        mockMvc.perform(get("/country"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.countryCode").value("IN"))
                .andExpect(jsonPath("$.countryName").value("India"))
                .andExpect(jsonPath("$.capital").value("New Delhi"))
                .andExpect(jsonPath("$.currency").value("Indian Rupee (INR)"));
    }

    @Test
    public void testGetCountryByCode() throws Exception {
        Country usa = new Country("US", "United States of America", "Washington, D.C.", 
                                331002651L, "US Dollar (USD)", 
                                "Americas", "Northern America", 9833517.0);
        
        when(countryService.getCountryByCode("US")).thenReturn(usa);

        mockMvc.perform(get("/country").param("code", "US"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.countryCode").value("US"))
                .andExpect(jsonPath("$.countryName").value("United States of America"));
    }
}
