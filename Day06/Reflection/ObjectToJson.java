package com.capgeminitraining.day6.Reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class Person_s {
    private String name;
    private int age;
    private boolean isStudent;

    public Person_s(String name, int age, boolean isStudent) {
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
    }
}

public class ObjectToJson {
    public static String toJson(Object obj) {
        try {
            Class<?> objClass = obj.getClass();
            Map<String, Object> jsonMap = new HashMap<>();

            // Iterate through all declared fields
            for (Field field : objClass.getDeclaredFields()) {
                field.setAccessible(true); // Allow access to private fields
                jsonMap.put(field.getName(), field.get(obj)); // Get field name and value
            }

            // Convert map to JSON-like string
            return jsonMap.toString().replace("=", ": ");
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public static void main(String[] args) {
        // Create an object
        Person_s person = new Person_s("Alice", 25, true);

        // Convert object to JSON
        String json = toJson(person);

        // Display JSON output
        System.out.println(json);
    }
}
