package com.example.junit;

// Represents an employee with an id, name, and salary.
public class Employee {

    private final int id;
    private final String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void incrementSalary(double amount) {
        salary += amount;
    }
}