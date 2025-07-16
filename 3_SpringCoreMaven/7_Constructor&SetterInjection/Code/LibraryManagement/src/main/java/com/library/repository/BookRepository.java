package com.library.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.library.model.Book;

public class BookRepository {
    
    private final Map<String, Book> books;
    
    public BookRepository() {
        this.books = new HashMap<>();
        initializeSampleBooks();
        System.out.println("BookRepository initialized with sample data");
    }
    
    private void initializeSampleBooks() {
        addBook(new Book("1", "The Java Programming Language", "James Gosling", "978-0321349804"));
        addBook(new Book("2", "Spring in Action", "Craig Walls", "978-1617294945"));
        addBook(new Book("3", "Clean Code", "Robert C. Martin", "978-0132350884"));
    }
    
    /**
     * Add a new book to the repository
     */
    public void addBook(Book book) {
        if (book != null && book.getId() != null) {
            books.put(book.getId(), book);
        }
    }
    
    /**
     * Find a book by its ID
     */
    public Book findById(String id) {
        return books.get(id);
    }
    
    /**
     * Get all books in the repository
     */
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
    
    /**
     * Update an existing book
     */
    public void updateBook(Book book) {
        if (book != null && book.getId() != null) {
            books.put(book.getId(), book);
        }
    }
    
    /**
     * Delete a book by ID
     */
    public boolean deleteBook(String id) {
        return books.remove(id) != null;
    }
    
    /**
     * Find books by title (case-insensitive partial matching)
     */
    public List<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<>();
        if (title != null) {
            for (Book book : books.values()) {
                if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    result.add(book);
                }
            }
        }
        return result;
    }
    
    /**
     * Find books by author (case-insensitive partial matching)
     */
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        if (author != null) {
            for (Book book : books.values()) {
                if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                    result.add(book);
                }
            }
        }
        return result;
    }
    
    /**
     * Get the count of books in the repository
     */
    public int getBookCount() {
        return books.size();
    }
}
