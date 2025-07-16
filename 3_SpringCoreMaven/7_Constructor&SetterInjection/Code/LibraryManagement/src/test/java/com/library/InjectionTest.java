package com.library;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import static org.junit.Assert.*;

public class InjectionTest {
    
    private ApplicationContext context;
    
    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    @Test
    public void testConstructorInjection() {
        BookService service = (BookService) context.getBean("bookServiceConstructor");
        assertNotNull("BookService should not be null", service);
        assertNotNull("Should be able to get all books", service.getAllBooks());
        assertTrue("Should have initial books", !service.getAllBooks().isEmpty());
        assertEquals("Service name should match", "Library Service (Constructor Injection)", service.getServiceName());
    }
    
    @Test
    public void testSetterInjection() {
        BookService service = (BookService) context.getBean("bookServiceSetter");
        assertNotNull("BookService should not be null", service);
        assertNotNull("Should be able to get all books", service.getAllBooks());
        assertTrue("Should have initial books", !service.getAllBooks().isEmpty());
        assertEquals("Service name should match", "Library Service (Setter Injection)", service.getServiceName());
    }
    
    @Test
    public void testMixedInjection() {
        BookService service = (BookService) context.getBean("bookServiceMixed");
        assertNotNull("BookService should not be null", service);
        assertNotNull("Should be able to get all books", service.getAllBooks());
        assertTrue("Should have initial books", !service.getAllBooks().isEmpty());
        assertEquals("Service name should match", "Library Service (Mixed Injection)", service.getServiceName());
    }
    
    @Test
    public void testRepositoryInjection() {
        BookRepository repository = (BookRepository) context.getBean("bookRepository");
        assertNotNull("BookRepository should not be null", repository);
        assertTrue("Repository should have books", repository.getBookCount() > 0);
    }
    
    @Test
    public void testAllServiceVariationsWork() {
        BookService constructorService = (BookService) context.getBean("bookServiceConstructor");
        BookService setterService = (BookService) context.getBean("bookServiceSetter");
        BookService mixedService = (BookService) context.getBean("bookServiceMixed");
        
        assertNotSame("Constructor and setter services should be different instances", constructorService, setterService);
        assertNotSame("Constructor and mixed services should be different instances", constructorService, mixedService);
        assertNotSame("Setter and mixed services should be different instances", setterService, mixedService);
        
        assertEquals("All services should see same number of books", 
                    constructorService.getAllBooks().size(), 
                    setterService.getAllBooks().size());
        assertEquals("All services should see same number of books", 
                    setterService.getAllBooks().size(), 
                    mixedService.getAllBooks().size());
    }
}
