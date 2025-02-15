package com.capgeminitraining.day5.junit;

import java.util.regex.*;

public class PasswordValidator {
    public static boolean isValid(String password) {
        if (password == null) {
            return false;
        }
        // Password must be at least 8 characters long, contain at least one uppercase letter and one digit
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        return Pattern.matches(passwordRegex, password);
    }
}
