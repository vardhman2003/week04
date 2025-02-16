package com.capgeminitraining.day6.Reflection;

import java.lang.reflect.Method;

// Step 1: Define a Sample Class with Methods
class Task {
    public void quickTask() {
        System.out.println("Executing quickTask...");
    }

    public void slowTask() {
        System.out.println("Executing slowTask...");
        try {
            Thread.sleep(2000); // Simulate a slow method (2 seconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Step 2: Create a Utility to Measure Execution Time
public class MethodExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName) {
        try {
            // Get the method from the class
            Method method = obj.getClass().getMethod(methodName);

            // Measure execution time
            long startTime = System.nanoTime();
            method.invoke(obj); // Invoke the method
            long endTime = System.nanoTime();

            // Calculate execution duration
            long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

            // Print execution time
            System.out.println("Execution time of " + methodName + ": " + duration + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Task task = new Task();

        // Measure execution time for methods dynamically
        measureExecutionTime(task, "quickTask");
        measureExecutionTime(task, "slowTask");
    }
}
