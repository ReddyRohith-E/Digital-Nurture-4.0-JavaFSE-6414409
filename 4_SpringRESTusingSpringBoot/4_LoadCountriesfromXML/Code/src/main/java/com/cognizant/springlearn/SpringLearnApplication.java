package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main application class for Spring Learning
 */
public class SpringLearnApplication {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
    
    /**
     * Method to display country details by reading from Spring configuration
     */
    public static void displayCountry() {
        LOGGER.info("Starting displayCountry() method");
        
        // Load Spring configuration from XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("countries.xml");
        
        // Get the country bean from the context
        Country country = (Country) context.getBean("india", Country.class);
        
        // Display country details
        LOGGER.debug("Country : {}", country.toString());
        LOGGER.info("Country details - Code: {}, Name: {}", country.getCode(), country.getName());
        
        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
        
        LOGGER.info("Completed displayCountry() method");
    }
    
    /**
     * Main method - entry point of the application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        LOGGER.info("=== Spring Core - Load Country from XML Configuration ===");
        LOGGER.info("Starting Spring Learn Application");
        
        // Invoke the displayCountry method
        displayCountry();
        
        LOGGER.info("Spring Learn Application completed successfully");
    }
}
