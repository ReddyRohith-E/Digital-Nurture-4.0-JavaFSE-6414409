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
        System.out.println("BookRepository instantiated");
        // Initialize with some sample books
        initializeSampleBooks();
    }
    
    private void initializeSampleBooks() {
        addBook(new Book("1", "The Java Programming Language", "James Gosling", "978-0321349804"));
        addBook(new Book("2", "Spring in Action", "Craig Walls", "978-1617294945"));
        addBook(new Book("3", "Clean Code", "Robert C. Martin", "978-0132350884"));
        System.out.println("Sample books initialized in repository");
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
    
    public boolean removeBook(String id) {
        return books.remove(id) != null;
    }
    
    public void displayAllBooks() {
        System.out.println("\n=== All Books in Library ===");
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            for (Book book : books.values()) {
                System.out.println(book);
            }
        }
        System.out.println("============================\n");
    }
}
