package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApp {
    
    public static void main(String[] args) {
        System.out.println("=== Starting Library Management Application ===");
        System.out.println("Demonstrating Spring IoC Container Configuration");
        
        try {
            // Load Spring configuration from XML file
            System.out.println("\nLoading Spring Application Context from applicationContext.xml...");
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            System.out.println("Spring Application Context loaded successfully!");
            
            // Get BookService bean from Spring container
            System.out.println("\nRetrieving BookService bean from Spring container...");
            BookService bookService = (BookService) context.getBean("bookService");
            System.out.println("BookService bean retrieved successfully!");
            
            // Verify that dependencies are properly injected
            System.out.println("\n=== Testing Dependency Injection ===");
            System.out.println("BookService has been configured with BookRepository dependency via setter injection");
            
            // Perform library operations to test the configuration
            bookService.performLibraryOperations();
            
            // Additional demonstration - get beans by type
            System.out.println("=== Alternative Bean Retrieval Methods ===");
            BookService bookServiceByType = context.getBean(BookService.class);
            System.out.println("BookService also retrieved by type: " + bookServiceByType.getClass().getSimpleName());
            
            // Verify singleton scope (default)
            BookService bookService1 = (BookService) context.getBean("bookService");
            BookService bookService2 = (BookService) context.getBean("bookService");
            System.out.println("Same instance check (singleton scope): " + (bookService1 == bookService2));
            
            System.out.println("\n=== Application Completed Successfully ===");
            
            // Close the context (good practice)
            if (context instanceof ClassPathXmlApplicationContext) {
                ((ClassPathXmlApplicationContext) context).close();
                System.out.println("Spring Application Context closed.");
            }
            
        } catch (org.springframework.beans.BeansException e) {
            System.err.println("Spring BeansException occurred: " + e.getMessage());
            System.err.println(e);
        } catch (Exception e) {
            System.err.println("Unexpected error occurred while running the application: " + e.getMessage());
            System.err.println(e);
        }
    }
}
