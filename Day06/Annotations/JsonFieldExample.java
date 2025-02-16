package com.capgeminitraining.day6.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @JsonField Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@interface JsonField {
    String name(); // Custom JSON key name
}

// Step 2: Create a User Class with @JsonField Annotations
class User_s {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String password; // Not annotated, should be excluded

    public User_s(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }
}

// Step 3: Implement the JSON Serialization Logic
class JsonSerializer {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Map<String, String> jsonMap = new HashMap<>();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true); // Access private fields
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    jsonMap.put(annotation.name(), field.get(obj).toString());
                }
            }

            // Convert map to JSON-like string
            StringBuilder jsonString = new StringBuilder("{");
            for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
                jsonString.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
            }

            // Remove trailing comma and space, add closing brace
            if (jsonString.length() > 1) {
                jsonString.setLength(jsonString.length() - 2);
            }
            jsonString.append("}");

            return jsonString.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "{}"; // Return empty JSON on error
        }
    }
}

// Step 4: Test JSON Serialization
public class JsonFieldExample {
    public static void main(String[] args) {
        User_s user = new User_s("JohnDoe", 25, "secret123");

        // Convert the User object to JSON
        String json = JsonSerializer.toJson(user);
        System.out.println("Serialized JSON: " + json);
    }
}
