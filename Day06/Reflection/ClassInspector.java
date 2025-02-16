package com.capgeminitraining.day6.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

class Employee {  // Example class for testing
    private String name;
    public int age;

    public Employee() {}  // Default constructor
    public Employee(String name, int age) { this.name = name; this.age = age; }

    public void display() { System.out.println("Employee Name: " + name + ", Age: " + age); }
}

public class ClassInspector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept class name as input
        System.out.print("Enter the full class name (e.g., java.util.ArrayList or Employee): ");
        String className = scanner.nextLine();

        try {
            // Load the class dynamically
            Class<?> cls = Class.forName(className);

            // Display class name
            System.out.println("\nClass: " + cls.getName());

            // Display fields
            System.out.println("\nFields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("  " + field);
            }

            // Display methods
            System.out.println("\nMethods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("  " + method);
            }

            // Display constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("  " + constructor);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found - " + e.getMessage());
        }

        scanner.close();
    }
}
