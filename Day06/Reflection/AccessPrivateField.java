package com.capgeminitraining.day6.Reflection;

import java.lang.reflect.Field;

class Person {
    private int age;  // Private field

    // Constructor
    public Person(int age) {
        this.age = age;
    }

    // Method to display age
    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            Person person = new Person(25);

            // Display initial age
            System.out.println("Before modification:");
            person.displayAge();

            // Get the Class object
            Class<?> personClass = person.getClass();

            // Access the private field "age"
            Field ageField = personClass.getDeclaredField("age");

            // Allow modification of private field
            ageField.setAccessible(true);

            // Modify the private field
            ageField.set(person, 30);

            // Retrieve the modified value
            int modifiedAge = (int) ageField.get(person);

            // Display modified age
            System.out.println("\nAfter modification:");
            person.displayAge();
            System.out.println("Retrieved Age using Reflection: " + modifiedAge);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
