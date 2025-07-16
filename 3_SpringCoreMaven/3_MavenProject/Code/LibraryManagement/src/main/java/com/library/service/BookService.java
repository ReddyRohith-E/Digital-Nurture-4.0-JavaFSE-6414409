package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.repository.BookRepository;

/**
 * Service class for managing library operations
 * This class contains business logic for the library management system
 */
@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
    
    // Constructor injection (alternative to @Autowired)
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    // Default constructor for Spring
    public BookService() {
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
     * Get all books in the library
     */
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    /**
     * Search books by title
     */
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
    
    /**
     * Search books by author
     */
    public List<Book> searchBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }
    
    /**
     * Borrow a book (mark as unavailable)
     */
    public boolean borrowBook(String bookId) {
        Book book = bookRepository.findById(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            bookRepository.updateBook(book);
            System.out.println("Book borrowed successfully: " + book.getTitle());
            return true;
        } else if (book != null) {
            System.out.println("Book is not available for borrowing: " + book.getTitle());
        } else {
            System.out.println("Book not found with ID: " + bookId);
        }
        return false;
    }
    
    /**
     * Return a book (mark as available)
     */
    public boolean returnBook(String bookId) {
        Book book = bookRepository.findById(bookId);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            bookRepository.updateBook(book);
            System.out.println("Book returned successfully: " + book.getTitle());
            return true;
        } else if (book != null) {
            System.out.println("Book was not borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not found with ID: " + bookId);
        }
        return false;
    }
    
    /**
     * Remove a book from the library
     */
    public boolean removeBook(String bookId) {
        boolean removed = bookRepository.deleteBook(bookId);
        if (removed) {
            System.out.println("Book removed successfully with ID: " + bookId);
        } else {
            System.out.println("Book not found with ID: " + bookId);
        }
        return removed;
    }
    
    /**
     * Get total number of books in the library
     */
    public int getTotalBooks() {
        return bookRepository.getBookCount();
    }
    
    /**
     * Generate a unique book ID
     */
    private String generateBookId() {
        return "BOOK_" + System.currentTimeMillis();
    }
    
    /**
     * Display all books in a formatted way
     */
    public void displayAllBooks() {
        List<Book> books = getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("\n=== Library Books ===");
            for (Book book : books) {
                System.out.println(book);
            }
            System.out.println("Total books: " + books.size());
        }
    }
}
