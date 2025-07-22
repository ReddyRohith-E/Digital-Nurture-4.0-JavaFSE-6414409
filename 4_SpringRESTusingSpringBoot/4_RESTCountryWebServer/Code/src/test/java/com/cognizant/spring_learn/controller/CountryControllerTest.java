package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for CountryController
 * Tests the REST endpoint functionality
 */
@WebMvcTest(CountryController.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test the /country endpoint
     * Verifies that the endpoint returns India country details in JSON format
     */
    @Test
    public void testGetCountryIndia() throws Exception {
        mockMvc.perform(get("/country"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.code").value("IN"))
                .andExpect(jsonPath("$.name").value("India"));
    }
}
