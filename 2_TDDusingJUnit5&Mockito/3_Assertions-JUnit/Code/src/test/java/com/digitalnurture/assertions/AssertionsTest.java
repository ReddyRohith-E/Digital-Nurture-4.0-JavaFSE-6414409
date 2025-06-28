package com.digitalnurture.assertions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Exercise 3: Assertions in JUnit
 */
public class AssertionsTest {
    
    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);
        
        // Assert true
        assertTrue(5 > 3);
        
        // Assert false
        assertFalse(5 < 3);
        
        // Assert null
        assertNull(null);
        
        // Assert not null
        assertNotNull(new Object());
    }
    
    @Test
    public void testAdditionalAssertions() {
        // Assert equals with message
        assertEquals(10, 4 + 6, "4 + 6 should equal 10");
        
        // Assert not equals
        assertNotEquals(5, 2 + 2, "2 + 2 should not equal 5");
        
        // Assert same (reference equality)
        String str1 = "Hello";
        String str2 = str1;
        assertSame(str1, str2, "Both references should point to the same object");
        
        // Assert not same (different references)
        String str3 = new String("Hello");
        String str4 = new String("Hello");
        assertNotSame(str3, str4, "Different string objects should not be the same reference");
        
        // Assert array equals
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual, "Arrays should be equal");
        
        // Assert throws (exception testing)
        assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0;
        }, "Division by zero should throw ArithmeticException");
        
        // Assert does not throw
        assertDoesNotThrow(() -> {
            int result = 10 / 2;
        }, "Valid division should not throw an exception");
        
        assertAll("Multiple assertions",
            () -> assertEquals(2, 1 + 1, "1 + 1 should equal 2"),
            () -> assertTrue(3 > 1, "3 should be greater than 1"),
            () -> assertFalse(2 > 5, "2 should not be greater than 5"),
            () -> assertNotNull("test", "String should not be null")
        );
    }
    
    @Test
    public void testStringAssertions() {
        String actual = "Hello World";
        
        // Assert equals for strings
        assertEquals("Hello World", actual);
        
        // Assert true for string conditions
        assertTrue(actual.startsWith("Hello"));
        assertTrue(actual.endsWith("World"));
        assertTrue(actual.contains("lo Wo"));
        
        // Assert false for string conditions
        assertFalse(actual.isEmpty());
        assertFalse(actual.startsWith("Hi"));
    }
    
    @Test
    public void testNumericAssertions() {
        double expected = 3.14159;
        double actual = 3.14159;
        
        // Assert equals with delta for floating point numbers
        assertEquals(expected, actual, 0.00001, "Pi values should be approximately equal");
        
        // Assert true for numeric comparisons
        assertTrue(10 > 5, "10 should be greater than 5");
        assertTrue(-5 < 0, "-5 should be less than 0");
        
        // Assert false for numeric comparisons
        assertFalse(3 > 10, "3 should not be greater than 10");
        assertFalse(0 < -1, "0 should not be less than -1");
    }
}