package com.capgeminitraining.day6.Reflection;

import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    // Default Constructor
    public Student() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Parameterized Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display student info
    public void display() {
        System.out.println("Student Name: " + name + ", Age: " + age);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            // Get the Class object
            Class<?> studentClass = Class.forName("org.example.Reflection.Student");

            // Create an instance using the default constructor
            Object student1 = studentClass.getDeclaredConstructor().newInstance();
            System.out.println("Object created using default constructor:");
            ((Student) student1).display();

            // Create an instance using the parameterized constructor
            Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class, int.class);
            Object student2 = constructor.newInstance("Alice", 20);
            System.out.println("\nObject created using parameterized constructor:");
            ((Student) student2).display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
