package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

/**
 * Main application class to demonstrate Spring configuration and dependency injection
 */
public class LibraryManagementApp {
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Library Management System - Spring Demo");
        System.out.println("========================================");
        
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            System.out.println("\n1. Loading Spring Application Context...");
            System.out.println("Spring Application Context loaded successfully!");

            System.out.println("\n2. Retrieving BookService bean from Spring context...");
            BookService bookService = context.getBean("bookService", BookService.class);
            System.out.println("BookService bean retrieved successfully!");
 
            System.out.println("\n3. Testing Library Management Operations:");
            System.out.println("=========================================");

            System.out.println("\n--- Initial Books in Library ---");
            bookService.displayAllBooks();
 
            System.out.println("\n--- Adding New Books ---");
            bookService.addBook("Introduction to Algorithms by Cormen, Leiserson, Rivest, and Stein");
            bookService.addBook("Design Patterns");
            
            System.out.println("\n--- All Books After Addition ---");
            bookService.displayAllBooks();
            
            System.out.println("\n--- Searching for Books ---");
            String foundBook = bookService.searchBook("Structural Analysis");
            if (foundBook != null) {
                System.out.println("Search successful: " + foundBook);
            }
            
            String notFound = bookService.searchBook("Non-existent Book");
            if (notFound == null) {
                System.out.println("Search correctly returned null for non-existent book");
            }
            
            System.out.println("\n--- Removing a Book ---");
            boolean removed = bookService.removeBook("Clean Code");
            if (removed) {
                System.out.println("Book removal successful");
            }
            
            // Display final state
            System.out.println("\n--- Final Books in Library ---");
            bookService.displayAllBooks();
            
            System.out.println("\n========================================");
            System.out.println("Spring Application Demo Completed Successfully!");
            System.out.println("========================================");
            
        } catch (Exception e) {
            System.err.println("Error occurred while running the application:");
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
