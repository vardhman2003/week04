package com.capgeminitraining.day6.Reflection;

import java.lang.reflect.Field;

class Configuration {
    // Private static field
    private static String API_KEY = "DEFAULT_KEY";

    // Method to display the API_KEY
    public static void displayKey() {
        System.out.println("API_KEY: " + API_KEY);
    }
}

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            // Display the initial API_KEY
            System.out.println("Before modification:");
            Configuration.displayKey();

            // Get the Class object
            Class<?> configClass = Configuration.class;

            // Access the private static field "API_KEY"
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Make the field accessible
            apiKeyField.setAccessible(true);

            // Modify the private static field
            apiKeyField.set(null, "NEW_SECRET_KEY");

            // Display the modified API_KEY
            System.out.println("\nAfter modification:");
            Configuration.displayKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
