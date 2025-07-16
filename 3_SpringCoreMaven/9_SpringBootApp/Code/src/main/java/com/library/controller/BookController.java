package com.library.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Book;
import com.library.repository.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        logger.debug("Getting all books");
        List<Book> books = bookRepository.findAll();
        logger.debug("Found {} books", books.size());
        return books;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        logger.debug("Getting book with id: {}", id);
        return bookRepository.findById(id)
                .map(book -> {
                    logger.debug("Found book: {}", book);
                    return ResponseEntity.ok(book);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        logger.debug("Creating new book: {}", book);
        Book savedBook = bookRepository.save(book);
        logger.debug("Created book with id: {}", savedBook.getId());
        return savedBook;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        logger.debug("Updating book with id: {}", id);
        return bookRepository.findById(id)
                .map(existingBook -> {
                    logger.debug("Found book to update: {}", existingBook);
                    existingBook.setTitle(bookDetails.getTitle());
                    existingBook.setAuthor(bookDetails.getAuthor());
                    existingBook.setIsbn(bookDetails.getIsbn());
                    Book updatedBook = bookRepository.save(existingBook);
                    logger.debug("Updated book: {}", updatedBook);
                    return ResponseEntity.ok(updatedBook);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        logger.debug("Deleting book with id: {}", id);
        return bookRepository.findById(id)
                .map(book -> {
                    logger.debug("Found book to delete: {}", book);
                    bookRepository.delete(book);
                    logger.debug("Book deleted successfully");
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
