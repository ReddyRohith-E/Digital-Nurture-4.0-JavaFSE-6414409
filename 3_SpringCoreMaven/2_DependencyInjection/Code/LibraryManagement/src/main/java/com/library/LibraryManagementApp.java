package com.library;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;
public class LibraryManagementApp {
    
    public static void main(String[] args) {
        System.out.println("=======================================================");
        System.out.println("Library Management System - Dependency Injection Demo");
        System.out.println("=======================================================");
        
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            
            System.out.println("\n1. Loading Spring Application Context...");
            System.out.println("   Spring Context loaded successfully!");

            System.out.println("\n2. Retrieving BookService bean from Spring context...");
            BookService bookService = context.getBean("bookService", BookService.class);
            System.out.println("   BookService bean retrieved successfully!");
            
            System.out.println("\n3. Verifying Dependency Injection...");
            boolean isDIWorking = bookService.isDependencyInjected();
            if (isDIWorking) {
                System.out.println("Dependency Injection is working correctly!");
                System.out.println("BookRepository has been successfully injected into BookService!");
            } else {
                System.out.println("Dependency Injection failed!");
                return;
            }

            System.out.println("\n4. Testing Library Management Operations:");
            System.out.println("==========================================");

            // Display initial books
            System.out.println("\n--- Initial Books in Library ---");
            bookService.displayAllBooks();
 
            // Add new books
            System.out.println("\n--- Adding New Books ---");
            bookService.addBook("Head First Design Patterns");
            bookService.addBook("Spring Boot in Action");
            bookService.addBook("Microservices Patterns");
            
            // Display all books after addition
            System.out.println("\n--- All Books After Addition ---");
            bookService.displayAllBooks();
            
            // Search for books
            System.out.println("\n--- Searching for Books ---");
            String foundBook = bookService.searchBook("Spring");
            if (foundBook != null) {
                System.out.println("Search successful: " + foundBook);
            }
            
            String notFound = bookService.searchBook("Non-existent Book");
            if (notFound == null) {
                System.out.println("Search correctly returned null for non-existent book");
            }
            
            // Remove a book
            System.out.println("\n--- Removing a Book ---");
            boolean removed = bookService.removeBook("Clean Code");
            if (removed) {
                System.out.println("Book removal successful");
            }
            
            // Display final state
            System.out.println("\n--- Final Books in Library ---");
            bookService.displayAllBooks();
            
            // Final verification
            System.out.println("\n5. Final Dependency Injection Verification:");
            System.out.println("===========================================");
            bookService.isDependencyInjected();
            
            System.out.println("\n=======================================================");
            System.out.println("Dependency Injection Demo Completed Successfully!");
            System.out.println("BookRepository was successfully injected into BookService");
            System.out.println("All library operations completed successfully");
            System.out.println("=======================================================");
            
        } catch (Exception e) {
            System.err.println("\nError occurred while running the application:");
            System.err.println("   Exception: " + e.getMessage());
            for (StackTraceElement element : e.getStackTrace()) {
                System.err.println("\tat " + element);
            }
        }
    }
}
