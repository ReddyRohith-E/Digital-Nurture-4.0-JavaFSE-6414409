package com.example;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testAddition() {
        final Calculator calculator = new Calculator();
        Assert.assertEquals(5, calculator.add(2, 3));
    }
    
    @Test
    public void testSubtraction() {
        final Calculator calculator = new Calculator();
        Assert.assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    public void testMultiplication() {
        final Calculator calculator = new Calculator();
        Assert.assertEquals(6, calculator.multiply(2, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivision() {
        final Calculator calculator = new Calculator();
        calculator.divide(2, 0);
    }
}