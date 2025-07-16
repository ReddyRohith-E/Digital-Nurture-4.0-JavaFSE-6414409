package com.library.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.library.model.Book;

/**
 * Simple in-memory repository for managing books
 * In a real application, this would connect to a database
 */
@Repository
public class BookRepository {
    
    private final Map<String, Book> books;
    
    public BookRepository() {
        this.books = new HashMap<>();
        // Initialize with some sample books
        initializeSampleBooks();
    }
    
    private void initializeSampleBooks() {
        addBook(new Book("1", "The Java Programming Language", "James Gosling", "978-0321349804"));
        addBook(new Book("2", "Spring in Action", "Craig Walls", "978-1617294945"));
        addBook(new Book("3", "Clean Code", "Robert C. Martin", "978-0132350884"));
    }
    
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }
    
    public Book findById(String id) {
        return books.get(id);
    }
    
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
    
    public List<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
    
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
    
    public boolean deleteBook(String id) {
        return books.remove(id) != null;
    }
    
    public void updateBook(Book book) {
        books.put(book.getId(), book);
    }
    
    public int getBookCount() {
        return books.size();
    }
}
