package com.library.service;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.library.model.Book;

/**
 * Test class for BookService
 * Demonstrates Spring integration testing
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BookServiceTest {
    
    @Autowired
    private BookService bookService;
    
    @Before
    public void setUp() {
        // Setup method runs before each test
        assertNotNull("BookService should be injected by Spring", bookService);
    }
    
    @Test
    public void testGetAllBooks() {
        List<Book> books = bookService.getAllBooks();
        assertNotNull("Books list should not be null", books);
        assertTrue("Should have at least 3 initial books", books.size() >= 3);
    }
    
    @Test
    public void testAddBook() {
        int initialCount = bookService.getTotalBooks();
        
        Book newBook = new Book("TEST_1", "Test Book", "Test Author", "123456789");
        bookService.addBook(newBook);
        
        assertEquals("Book count should increase by 1", initialCount + 1, bookService.getTotalBooks());
        
        Book foundBook = bookService.findBookById("TEST_1");
        assertNotNull("Added book should be found", foundBook);
        assertEquals("Book title should match", "Test Book", foundBook.getTitle());
    }
    
    @Test
    public void testSearchBooksByTitle() {
        List<Book> javaBooks = bookService.searchBooksByTitle("Java");
        assertNotNull("Search result should not be null", javaBooks);
        assertFalse("Should find at least one Java book", javaBooks.isEmpty());
        
        // Check that all found books contain "Java" in title
        for (Book book : javaBooks) {
            assertTrue("Book title should contain 'Java'", 
                      book.getTitle().toLowerCase().contains("java"));
        }
    }
    
    @Test
    public void testBorrowAndReturnBook() {
        // Find the first available book
        List<Book> books = bookService.getAllBooks();
        Book testBook = null;
        for (Book book : books) {
            if (book.isAvailable()) {
                testBook = book;
                break;
            }
        }
        
        assertNotNull("Should have at least one available book", testBook);
        
        // Test borrowing
        boolean borrowResult = bookService.borrowBook(testBook.getId());
        assertTrue("Should be able to borrow the book", borrowResult);
        
        Book borrowedBook = bookService.findBookById(testBook.getId());
        assertFalse("Book should be marked as not available", borrowedBook.isAvailable());
        
        // Test returning
        boolean returnResult = bookService.returnBook(testBook.getId());
        assertTrue("Should be able to return the book", returnResult);
        
        Book returnedBook = bookService.findBookById(testBook.getId());
        assertTrue("Book should be marked as available", returnedBook.isAvailable());
    }
    
    @Test
    public void testSearchByNonExistentTitle() {
        List<Book> books = bookService.searchBooksByTitle("NonExistentTitle");
        assertNotNull("Search result should not be null", books);
        assertTrue("Should return empty list for non-existent title", books.isEmpty());
    }
    
    @Test
    public void testFindByNonExistentId() {
        Book book = bookService.findBookById("NON_EXISTENT_ID");
        assertNull("Should return null for non-existent ID", book);
    }
}
