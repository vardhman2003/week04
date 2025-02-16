package com.capgeminitraining.day6.Reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Sample class for mapping
class Persons {
    private String name;
    private int age;

    // Default constructor
    public Persons() {}

    // Method to display object data
    public void display() {
        System.out.println("Person Name: " + name + ", Age: " + age);
    }
}

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance of the given class
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Iterate through the map and set field values
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                try {
                    // Get the field by name
                    Field field = clazz.getDeclaredField(fieldName);

                    // Make private fields accessible
                    field.setAccessible(true);

                    // Set the field value
                    field.set(obj, fieldValue);
                } catch (NoSuchFieldException e) {
                    System.out.println("Warning: Field '" + fieldName + "' not found in class " + clazz.getName());
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Sample properties map
        Map<String, Object> personData = new HashMap<>();

        personData.put("name","Alice");
        personData.put("age",25);
        // Convert map to Person object
        Persons person = toObject(Persons.class, personData);

        // Display the created object's data
        if (person != null) {
            person.display();
        }
    }
}
