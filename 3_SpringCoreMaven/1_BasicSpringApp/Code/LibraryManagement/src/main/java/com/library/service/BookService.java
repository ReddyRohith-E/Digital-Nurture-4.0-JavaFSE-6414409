package com.library.service;

import java.util.List;

import com.library.repository.BookRepository;

/**
 * BookService class to handle business logic for book operations
 */
public class BookService {
    
    private BookRepository bookRepository;
    
    public BookService() {
        System.out.println("BookService bean has been created.");
    }
    
    /**
     * Setter method for dependency injection of BookRepository
     * @param bookRepository the repository to inject
     */
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository has been injected into BookService.");
    }
    
    /**
     * Add a new book to the library
     * @param bookTitle the title of the book to add
     */
    public void addBook(String bookTitle) {
        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            System.out.println("Invalid book title provided.");
            return;
        }
        
        System.out.println("BookService: Adding book - " + bookTitle);
        bookRepository.save(bookTitle);
    }
    
    /**
     * Get all books from the library
     * @return list of all books
     */
    public List<String> getAllBooks() {
        System.out.println("BookService: Retrieving all books...");
        return bookRepository.findAll();
    }
    
    /**
     * Search for a book by title
     * @param title the title to search for
     * @return the book if found, null otherwise
     */
    public String searchBook(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Invalid search title provided.");
            return null;
        }
        
        System.out.println("BookService: Searching for book - " + title);
        return bookRepository.findByTitle(title);
    }
    
    /**
     * Remove a book from the library
     * @param title the title of the book to remove
     * @return true if book was removed, false otherwise
     */
    public boolean removeBook(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Invalid book title provided for deletion.");
            return false;
        }
        
        System.out.println("BookService: Removing book - " + title);
        return bookRepository.delete(title);
    }
    
    /**
     * Display all books in the library
     */
    public void displayAllBooks() {
        System.out.println("BookService: Displaying all books in the library:");
        List<String> books = getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books found in the library.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }
}
