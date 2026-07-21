package com.example.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CalculatorTest {

    @Test
    public void addShouldReturnSum() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.add(10, 20);

        // Assert
        assertEquals(30, result);
    }

    @Test
    public void subtractShouldReturnDifference() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.subtract(20, 10);

        // Assert
        assertEquals(10, result);
    }

    @Test
    public void multiplyShouldReturnProduct() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.multiply(5, 4);

        // Assert
        assertEquals(20, result);
        assertTrue(result > 0);
    }

    @Test
    public void divideShouldReturnQuotient() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        double result = calculator.divide(20, 4);

        // Assert
        assertEquals(5.0, result, 0.0001);
        assertTrue(result > 0);
    }

    @Test
    public void divideByZeroShouldThrowArithmeticException() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        try {
            calculator.divide(10, 0);
            fail("Expected ArithmeticException to be thrown");
        } catch (ArithmeticException exception) {
            // Assert
            assertTrue(exception.getMessage().contains("Division by zero"));
        }
    }
}