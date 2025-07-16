package com.library.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * BookRepository class to handle data access operations for books
 */
public class BookRepository {
    
    private final List<String> books;
    
    public BookRepository() {
        this.books = new ArrayList<>();
        books.add("Java: The Complete Reference");
        books.add("Structural Analysis");
        books.add("Effective Java");
        books.add("Clean Code");
        System.out.println("BookRepository bean has been created and initialized.");
    }
    
    /**
     * Save a book to the repository
     * @param bookTitle the title of the book to save
     */
    public void save(String bookTitle) {
        books.add(bookTitle);
        System.out.println("Book saved: " + bookTitle);
    }
    
    /**
     * Find all books in the repository
     * @return list of all books
     */
    public List<String> findAll() {
        System.out.println("Fetching all books from repository...");
        return new ArrayList<>(books);
    }
    
    /**
     * Find a book by title
     * @param title the title to search for
     * @return the book title if found, null otherwise
     */
    public String findByTitle(String title) {
        for (String book : books) {
            if (book.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book);
                return book;
            }
        }
        System.out.println("Book not found: " + title);
        return null;
    }
    
    /**
     * Delete a book from the repository
     * @param title the title of the book to delete
     * @return true if book was deleted, false otherwise
     */
    public boolean delete(String title) {
        boolean removed = books.removeIf(book -> book.equalsIgnoreCase(title));
        if (removed) {
            System.out.println("Book deleted: " + title);
        } else {
            System.out.println("Book not found for deletion: " + title);
        }
        return removed;
    }
}
