package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get all types of BookService beans and demonstrate their functionality
        BookService constructorService = (BookService) context.getBean("bookServiceConstructor");
        BookService setterService = (BookService) context.getBean("bookServiceSetter");
        BookService mixedService = (BookService) context.getBean("bookServiceMixed");

        System.out.println("\nDemonstrating Different Types of Dependency Injection:");
        System.out.println("------------------------------------------------");

        // Demonstrate Constructor Injection
        System.out.println("\n1. Constructor Injection:");
        System.out.println("Service Name: " + constructorService.getServiceName());
        System.out.println("Number of Books: " + constructorService.getAllBooks().size());

        // Demonstrate Setter Injection
        System.out.println("\n2. Setter Injection:");
        System.out.println("Service Name: " + setterService.getServiceName());
        System.out.println("Number of Books: " + setterService.getAllBooks().size());

        // Demonstrate Mixed Injection
        System.out.println("\n3. Mixed Injection:");
        System.out.println("Service Name: " + mixedService.getServiceName());
        System.out.println("Number of Books: " + mixedService.getAllBooks().size());

        // Close the application context to prevent resource leak
        ((ConfigurableApplicationContext) context).close();
    }
}
