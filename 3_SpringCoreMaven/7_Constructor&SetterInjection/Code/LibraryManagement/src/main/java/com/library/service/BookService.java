package com.library.service;

import java.util.List;
import com.library.model.Book;
import com.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;
    private String serviceName;
    
        public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService created using constructor injection with BookRepository");
    }
    
    public BookService() {
        System.out.println("BookService created using default constructor");
    }
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected using setter injection");
    }
    
    /**
     * Setter injection for service name property
     * This demonstrates injecting simple values via setter injection
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
        System.out.println("Service name set to: " + serviceName);
    }
    
    /**
     * Getter for service name
     */
    public String getServiceName() {
        return serviceName;
    }
    
    /**
     * Add a new book to the library
     */
    public void addBook(Book book) {
        if (bookRepository == null) {
            throw new IllegalStateException("BookRepository not initialized!");
        }
        
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
        if (bookRepository == null) {
            throw new IllegalStateException("BookRepository not initialized!");
        }
        
        Book book = bookRepository.findById(id);
        if (book == null) {
            System.out.println("Book with ID " + id + " not found.");
        }
        return book;
    }
    
    /**
     * Get all books in the library
     */
    public List<Book> getAllBooks() {
        if (bookRepository == null) {
            throw new IllegalStateException("BookRepository not initialized!");
        }
        return bookRepository.findAll();
    }
    
    /**
     * Display all books in the library
     */
    public void displayAllBooks() {
        List<Book> books = getAllBooks();
        System.out.println("Total books in library: " + books.size());
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor() + 
                             " (ID: " + book.getId() + ", Available: " + book.isAvailable() + ")");
        }
    }
    
    /**
     * Search books by title
     */
    public List<Book> searchBooksByTitle(String title) {
        if (bookRepository == null) {
            throw new IllegalStateException("BookRepository not initialized!");
        }
        return bookRepository.findByTitle(title);
    }
    
    /**
     * Search books by author
     */
    public List<Book> searchBooksByAuthor(String author) {
        if (bookRepository == null) {
            throw new IllegalStateException("BookRepository not initialized!");
        }
        return bookRepository.findByAuthor(author);
    }
    
    /**
     * Borrow a book (mark as unavailable)
     */
    public boolean borrowBook(String bookId) {
        Book book = findBookById(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            bookRepository.updateBook(book);
            System.out.println("Book borrowed successfully: " + book.getTitle());
            return true;
        } else if (book != null) {
            System.out.println("Book is not available for borrowing: " + book.getTitle());
        }
        return false;
    }
    
    /**
     * Return a book (mark as available)
     */
    public boolean returnBook(String bookId) {
        Book book = findBookById(bookId);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            bookRepository.updateBook(book);
            System.out.println("Book returned successfully: " + book.getTitle());
            return true;
        } else if (book != null) {
            System.out.println("Book is already available: " + book.getTitle());
        }
        return false;
    }
    
    /**
     * Generate a unique book ID
     */
    private String generateBookId() {
        return "BOOK_" + System.currentTimeMillis();
    }
    
    /**
     * Display service information
     */
    public void displayServiceInfo() {
        System.out.println("=== BookService Information ===");
        System.out.println("Service Name: " + (serviceName != null ? serviceName : "Not set"));
        System.out.println("Repository Initialized: " + (bookRepository != null ? "Yes" : "No"));
        if (bookRepository != null) {
            System.out.println("Total Books in Repository: " + bookRepository.getBookCount());
        }
    }
}
