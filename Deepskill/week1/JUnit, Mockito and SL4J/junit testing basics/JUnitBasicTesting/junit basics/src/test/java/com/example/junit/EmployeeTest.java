package com.example.junit;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

// Verifies Employee salary behavior using the AAA testing pattern.
public class EmployeeTest {

    private Employee employee;

    @Before
    public void setup() {
        // Setup creates a shared Employee object so each test avoids duplicate initialization code.
        System.out.println("Before Test");
        employee = new Employee(1, "John Doe", 50000.0);
    }

    @After
    public void cleanup() {
        // Teardown is useful for releasing test state or logging after each test finishes.
        System.out.println("After Test");
    }

    @Test
    public void testIncrementSalary() {
        // Arrange: the common Employee object is created in setup() to avoid duplicate code.

        // Act: increase the salary by a specific amount.
        employee.incrementSalary(5000.0);

        // Assert: verify the updated salary.
        assertEquals(55000.0, employee.getSalary(), 0.0001);
    }
}