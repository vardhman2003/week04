package com.capgeminitraining.day6.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define the Custom Annotation
@Retention(RetentionPolicy.RUNTIME) // Make annotation available at runtime
@interface ImportantMethod {
    String level() default "HIGH"; // Default importance level
}

// Step 2: Create a Class with Annotated Methods
class CriticalOperations {

    @ImportantMethod(level = "CRITICAL")
    public void processData() {
        System.out.println("Processing important data...");
    }

    @ImportantMethod // Uses default level "HIGH"
    public void generateReport() {
        System.out.println("Generating report...");
    }

    public void helperMethod() {
        System.out.println("Helper method - not marked as important.");
    }
}

// Step 3: Retrieve and Print Annotated Methods Using Reflection
public class ImportantMethodExample {
    public static void main(String[] args) {
        try {
            // Get the CriticalOperations class
            Class<CriticalOperations> clazz = CriticalOperations.class;

            // Iterate over methods to find @ImportantMethod annotations
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                    System.out.println("Important Method: " + method.getName() + " (Level: " + annotation.level() + ")");
                }
            }

            // Execute the methods
            CriticalOperations operations = new CriticalOperations();
            operations.processData();
            operations.generateReport();
            operations.helperMethod();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
