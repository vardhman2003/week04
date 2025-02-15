package com.capgeminitraining.day5.junit;

import java.util.regex.Pattern;

public class UserRegistration {
    // Regular expressions for validation
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d).{8,}$";

    public static String registerUser(String username, String email, String password) {
        if (username == null || username.trim().length() < 5) {
            throw new IllegalArgumentException("Invalid username: must be at least 5 characters long.");
        }
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        if (!Pattern.matches(PASSWORD_REGEX, password)) {
            throw new IllegalArgumentException("Invalid password: must have at least 8 characters, one uppercase letter, and one digit.");
        }

        return "User registered successfully!";
    }
}
