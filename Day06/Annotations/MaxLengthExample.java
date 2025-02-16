package com.capgeminitraining.day6.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

// Step 1: Define the @MaxLength Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@interface MaxLength {
    int value(); // Maximum allowed length
}

// Step 2: Create a User Class with the Annotation
class User {
    @MaxLength(10) // Restrict username to max 10 characters
    private String username;

    public User(String username) {
        validateMaxLength(this, username);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    // Step 3: Validate the Field Length Using Reflection
    private void validateMaxLength(Object obj, String value) {
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(MaxLength.class)) {
                    MaxLength annotation = field.getAnnotation(MaxLength.class);
                    if (value.length() > annotation.value()) {
                        throw new IllegalArgumentException(
                                "Error: " + field.getName() + " exceeds max length of " + annotation.value()
                        );
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Step 4: Test the Annotation
public class MaxLengthExample {
    public static void main(String[] args) {
        try {
            // Valid username
            User user1 = new User("JohnDoe");
            System.out.println("User created: " + user1.getUsername());

            // Invalid username (exceeds max length)
            User user2 = new User("VeryLongUsername"); // This should throw an exception

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Handle validation error
        }
    }
}
