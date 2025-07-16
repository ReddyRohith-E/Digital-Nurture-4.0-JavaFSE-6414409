package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.model.Book;
import com.library.service.BookService;

/**
 * Main application class for the Library Management System
 * This demonstrates basic Spring dependency injection and bean management
 */
public class LibraryManagementApp {
    
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===");
        System.out.println("Starting Spring Application...");
        
        // Load Spring context from XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Get the BookService bean from Spring container
        BookService bookService = context.getBean(BookService.class);
        
        System.out.println("Spring container initialized successfully!");
        System.out.println("BookService bean retrieved from Spring container.");
        
        // Demonstrate basic library operations
        demonstrateLibraryOperations(bookService);
        
        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
        System.out.println("\nApplication completed successfully!");
    }
    
    /**
     * Demonstrates basic library management operations
     */
    private static void demonstrateLibraryOperations(BookService bookService) {
        System.out.println("\n=== Demonstrating Library Operations ===");
        
        // Display initial books (loaded from repository)
        System.out.println("\n1. Initial books in the library:");
        bookService.displayAllBooks();
        
        // Add a new book
        System.out.println("\n2. Adding a new book:");
        Book newBook = new Book("4", "Effective Java", "Joshua Bloch", "978-0134685991");
        bookService.addBook(newBook);
        
        // Search for books
        System.out.println("\n3. Searching books by title 'Java':");
        java.util.List<Book> javaBooks = bookService.searchBooksByTitle("Java");
        for (Book book : javaBooks) {
            System.out.println(book);
        }
        
        // Borrow a book
        System.out.println("\n4. Borrowing a book:");
        bookService.borrowBook("1");
        
        // Try to borrow the same book again
        System.out.println("\n5. Trying to borrow the same book again:");
        bookService.borrowBook("1");
        
        // Return the book
        System.out.println("\n6. Returning the book:");
        bookService.returnBook("1");
        
        // Display final state
        System.out.println("\n7. Final state of library:");
        bookService.displayAllBooks();
        
        System.out.println("\nTotal books in library: " + bookService.getTotalBooks());
    }
}
