package com.digitalnurture.assertions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Test class for Calculator using various JUnit assertions.
 * This demonstrates practical usage of assertions in testing a real class.
 */
public class TestClass {
    
    private Main obj;
    
    @BeforeEach
    public void setUp() {
        obj = new Main();
    }
    
    @Test
    public void testAddition() {
        // Assert equals for addition
        assertEquals(8, obj.add(3, 5));
        assertEquals(0, obj.add(-5, 5));
        assertEquals(-8, obj.add(-3, -5));
        
        // Assert with custom message
        assertEquals(10, obj.add(4, 6), "4 + 6 should equal 10");
    }
    
    @Test
    public void testSubtraction() {
        // Assert equals for subtraction
        assertEquals(2, obj.subtract(5, 3));
        assertEquals(-10, obj.subtract(-5, 5));
        assertEquals(2, obj.subtract(-3, -5));
    }
    
    @Test
    public void testMultiplication() {
        // Assert equals for multiplication
        assertEquals(15, obj.multiply(3, 5));
        assertEquals(0, obj.multiply(0, 5));
        assertEquals(-15, obj.multiply(-3, 5));
        assertEquals(15, obj.multiply(-3, -5));
    }
    
    @Test
    public void testDivision() {
        // Assert equals with delta for division (floating point)
        assertEquals(2.0, obj.divide(10, 5), 0.0001);
        assertEquals(2.5, obj.divide(5, 2), 0.0001);
        assertEquals(-2.5, obj.divide(-5, 2), 0.0001);
        
        // Assert throws for division by zero
        assertThrows(ArithmeticException.class, () -> {
            obj.divide(10, 0);
        }, "Division by zero should throw ArithmeticException");
    }
    
    @Test
    public void testIsPositive() {
        // Assert true for positive numbers
        assertTrue(obj.isPositive(5));
        assertTrue(obj.isPositive(1));
        
        // Assert false for negative numbers and zero
        assertFalse(obj.isPositive(-5));
        assertFalse(obj.isPositive(0));
    }
    
    @Test
    public void testAbsoluteValue() {
        // Assert equals for absolute values
        assertEquals(5, obj.abs(5));
        assertEquals(5, obj.abs(-5));
        assertEquals(0, obj.abs(0));
        
        // Assert not equals
        assertNotEquals(-5, obj.abs(-5));
        
        // Assert true for always positive result
        assertTrue(obj.abs(-10) >= 0);
        assertTrue(obj.abs(10) >= 0);
    }
    
    @Test
    public void testObjInstance() {
        // Assert not null for obj instance
        assertNotNull(obj);
        
        // Assert same instance
        Main sameobj = obj;
        assertSame(obj, sameobj);
        
        // Assert not same for different instances
        Main differentobj = new Main();
        assertNotSame(obj, differentobj);
    }

    @Test
    public void testMultipleOperations() {
        // Test chaining operations and assert the final result
        int result = obj.add(obj.multiply(2, 3), obj.subtract(10, 5));
        assertEquals(11, result, "2*3 + (10-5) should equal 11");
        
        // Assert that operations don't throw exceptions
        assertDoesNotThrow(() -> {
            obj.add(1, 2);
            obj.subtract(5, 3);
            obj.multiply(2, 4);
            obj.divide(8, 2);
        });
    }
}
