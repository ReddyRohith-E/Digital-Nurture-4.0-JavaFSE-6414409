package com.library.service;

import java.util.List;
import com.library.repository.BookRepository;

/**
 * BookService class to handle business logic for book operations
 * This class demonstrates Spring's Dependency Injection using setter injection
 */
public class BookService {
    
    private BookRepository bookRepository;
    
    /**
     * Default constructor - Spring will call this when creating the bean
     */
    public BookService() {
        System.out.println("BookService bean has been created.");
    }
    
    /**
     * Setter method for dependency injection of BookRepository
     * This method will be called by Spring to inject the BookRepository dependency
     * @param bookRepository the repository to inject
     */
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository has been successfully injected into BookService using setter injection.");
    }
    
    /**
     * Getter method for BookRepository (optional, for testing purposes)
     * @return the injected BookRepository
     */
    public BookRepository getBookRepository() {
        return this.bookRepository;
    }
    
    /**
     * Add a new book to the library
     * @param bookTitle the title of the book to add
     */
    public void addBook(String bookTitle) {
        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            System.out.println("BookService: Invalid book title provided.");
            return;
        }
        
        System.out.println("BookService: Processing request to add book - " + bookTitle);
        bookRepository.save(bookTitle);
        System.out.println("BookService: Book addition completed.");
    }
    
    /**
     * Get all books from the library
     * @return list of all books
     */
    public List<String> getAllBooks() {
        System.out.println("BookService: Processing request to retrieve all books...");
        List<String> books = bookRepository.findAll();
        System.out.println("BookService: Retrieved " + books.size() + " books.");
        return books;
    }
    
    /**
     * Search for a book by title
     * @param title the title to search for
     * @return the book if found, null otherwise
     */
    public String searchBook(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("BookService: Invalid search title provided.");
            return null;
        }
        
        System.out.println("BookService: Processing search request for - " + title);
        String result = bookRepository.findByTitle(title);
        if (result != null) {
            System.out.println("BookService: Search completed successfully.");
        } else {
            System.out.println("BookService: Search completed - no matching book found.");
        }
        return result;
    }
    
    /**
     * Remove a book from the library
     * @param title the title of the book to remove
     * @return true if book was removed, false otherwise
     */
    public boolean removeBook(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("BookService: Invalid book title provided for deletion.");
            return false;
        }
        
        System.out.println("BookService: Processing request to remove book - " + title);
        boolean result = bookRepository.delete(title);
        if (result) {
            System.out.println("BookService: Book removal completed successfully.");
        } else {
            System.out.println("BookService: Book removal failed - book not found.");
        }
        return result;
    }
    
    /**
     * Display all books in the library
     */
    public void displayAllBooks() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("BookService: Displaying all books in the library:");
        System.out.println("=".repeat(50));
        
        List<String> books = getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books found in the library.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
        System.out.println("=".repeat(50));
        System.out.println("Total books: " + books.size());
        System.out.println("=".repeat(50));
    }
    
    /**
     * Get the count of books in the library
     * @return number of books
     */
    public int getBookCount() {
        return bookRepository.getBookCount();
    }
    
    /**
     * Method to verify that dependency injection is working
     * @return true if BookRepository is properly injected, false otherwise
     */
    public boolean isDependencyInjected() {
        boolean isInjected = (bookRepository != null);
        System.out.println("BookService: Dependency injection status - " + 
                          (isInjected ? "SUCCESS" : "FAILED"));
        return isInjected;
    }
}
