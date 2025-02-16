package com.capgeminitraining.day6.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define the @Todo Annotation
@Retention(RetentionPolicy.RUNTIME) // Retain annotation at runtime
@interface Todo {
    String task();        // Task description
    String assignedTo();  // Developer responsible
    String priority() default "MEDIUM"; // Default priority
}

// Step 2: Apply @Todo to Methods
class ProjectTasks {

    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void loginFeature() {
        System.out.println("Login feature implementation pending...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Database optimization pending...");
    }

    @Todo(task = "Improve UI design", assignedTo = "Charlie", priority = "LOW")
    public void improveUI() {
        System.out.println("UI improvement pending...");
    }

    public void completedFeature() {
        System.out.println("This feature is completed.");
    }
}

// Step 3: Retrieve and Print All @Todo Annotations Using Reflection
public class TodoAnnotationExample {
    public static void main(String[] args) {
        try {
            // Get the ProjectTasks class
            Class<ProjectTasks> clazz = ProjectTasks.class;

            // Iterate over methods to find @Todo annotations
            System.out.println("Pending Tasks:");
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Todo.class)) {
                    Todo annotation = method.getAnnotation(Todo.class);
                    System.out.println("- Task: " + annotation.task());
                    System.out.println("  Assigned To: " + annotation.assignedTo());
                    System.out.println("  Priority: " + annotation.priority());
                    System.out.println();
                }
            }

            // Execute the methods (for demonstration)
            ProjectTasks tasks = new ProjectTasks();
            tasks.loginFeature();
            tasks.optimizeDatabase();
            tasks.improveUI();
            tasks.completedFeature();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

