package com.library.service;

import java.util.List;

import com.library.model.Book;
import com.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;
    
    // Default constructor
    public BookService() {
        System.out.println("BookService instantiated");
    }
    
    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected into BookService via setter");
    }
    
    /**
     * Add a new book to the library
     */
    public void addBook(Book book) {
        if (book.getId() == null || book.getId().trim().isEmpty()) {
            book.setId(generateBookId());
        }
        bookRepository.addBook(book);
        System.out.println("Book added successfully: " + book.getTitle());
    }
    
    /**
     * Find a book by its ID
     */
    public Book findBookById(String id) {
        Book book = bookRepository.findById(id);
        if (book == null) {
            System.out.println("Book with ID " + id + " not found.");
        }
        return book;
    }
    
    /**
     * Find books by title (partial match)
     */
    public List<Book> findBooksByTitle(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        System.out.println("Found " + books.size() + " books with title containing: " + title);
        return books;
    }
    
    /**
     * Find books by author (partial match)
     */
    public List<Book> findBooksByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        System.out.println("Found " + books.size() + " books by author containing: " + author);
        return books;
    }
    
    /**
     * Get all books in the library
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    /**
     * Remove a book from the library
     */
    public boolean removeBook(String id) {
        boolean removed = bookRepository.removeBook(id);
        if (removed) {
            System.out.println("Book with ID " + id + " removed successfully.");
        } else {
            System.out.println("Book with ID " + id + " not found for removal.");
        }
        return removed;
    }
    
    /**
     * Display all books in the library
     */
    public void displayAllBooks() {
        bookRepository.displayAllBooks();
    }
    
    /**
     * Generate a unique book ID
     */
    private String generateBookId() {
        return "BOOK_" + System.currentTimeMillis();
    }
    
    /**
     * Perform various library operations for demonstration
     */
    public void performLibraryOperations() {
        System.out.println("\n=== Library Management Operations ===");
        
        // Display all books
        displayAllBooks();
        
        // Find a specific book
        System.out.println("Finding book with ID '1':");
        Book book = findBookById("1");
        if (book != null) {
            System.out.println("Found: " + book);
        }
        
        // Search books by title
        System.out.println("\nSearching for books with 'Spring' in title:");
        List<Book> springBooks = findBooksByTitle("Spring");
        springBooks.forEach(System.out::println);
        
        // Search books by author
        System.out.println("\nSearching for books by 'Martin':");
        List<Book> martinBooks = findBooksByAuthor("Martin");
        martinBooks.forEach(System.out::println);
        
        // Add a new book
        System.out.println("\nAdding a new book:");
        Book newBook = new Book("4", "Effective Java", "Joshua Bloch", "978-0134685991");
        addBook(newBook);
        
        // Display updated library
        displayAllBooks();
        
        System.out.println("=== Operations Completed ===\n");
    }
}
