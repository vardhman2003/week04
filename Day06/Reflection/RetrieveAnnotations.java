package com.capgeminitraining.day6.Reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

// Step 1: Define Custom Annotation
@Retention(RetentionPolicy.RUNTIME)  // Make it available at runtime
@interface Author {
    String name();
}

// Step 2: Apply Annotation to a Class
@Author(name = "John Doe")
class Book {
    public void display() {
        System.out.println("Book class method.");
    }
}

// Step 3: Use Reflection to Retrieve Annotation
public class RetrieveAnnotations {
    public static void main(String[] args) {
        try {
            // Get the Class object
            Class<?> bookClass = Book.class;

            // Check if @Author annotation is present
            if (bookClass.isAnnotationPresent(Author.class)) {
                // Retrieve the annotation
                Author author = bookClass.getAnnotation(Author.class);

                // Display annotation value
                System.out.println("Author Name: " + author.name());
            } else {
                System.out.println("No @Author annotation found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
