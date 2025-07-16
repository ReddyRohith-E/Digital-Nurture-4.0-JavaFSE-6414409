package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    
    private final List<String> books;
    
    public BookRepository() {
        this.books = new ArrayList<>();
        // Initialize with some sample books
        books.add("Java: The Complete Reference");
        books.add("Structural Analysis");
        books.add("Effective Java");
        books.add("Clean Code");
        books.add("Spring in Action");
        System.out.println("BookRepository bean has been created and initialized with sample data.");
    }
    
    /**
     * Save a book to the repository
     * @param bookTitle the title of the book to save
     */
    public void save(String bookTitle) {
        if (bookTitle != null && !bookTitle.trim().isEmpty()) {
            books.add(bookTitle);
            System.out.println("BookRepository: Book saved successfully - " + bookTitle);
        } else {
            System.out.println("BookRepository: Invalid book title provided for saving.");
        }
    }
    
    /**
     * Find all books in the repository
     * @return list of all books
     */
    public List<String> findAll() {
        System.out.println("BookRepository: Fetching all " + books.size() + " books from repository...");
        return new ArrayList<>(books);
    }
    
    /**
     * Find a book by title (case-insensitive search)
     * @param title the title to search for
     * @return the book title if found, null otherwise
     */
    public String findByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("BookRepository: Invalid search title provided.");
            return null;
        }
        
        for (String book : books) {
            if (book.toLowerCase().contains(title.toLowerCase())) {
                System.out.println("BookRepository: Book found - " + book);
                return book;
            }
        }
        System.out.println("BookRepository: Book not found - " + title);
        return null;
    }
    
    /**
     * Delete a book from the repository
     * @param title the title of the book to delete
     * @return true if book was deleted, false otherwise
     */
    public boolean delete(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("BookRepository: Invalid book title provided for deletion.");
            return false;
        }
        
        boolean removed = books.removeIf(book -> book.equalsIgnoreCase(title));
        if (removed) {
            System.out.println("BookRepository: Book deleted successfully - " + title);
        } else {
            System.out.println("BookRepository: Book not found for deletion - " + title);
        }
        return removed;
    }
    
    /**
     * Get the count of books in the repository
     * @return number of books
     */
    public int getBookCount() {
        return books.size();
    }
}
