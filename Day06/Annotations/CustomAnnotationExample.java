package com.capgeminitraining.day6.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define the Custom Annotation
@Retention(RetentionPolicy.RUNTIME) // Make annotation available at runtime
@interface TaskInfo {
    String assignedTo();
    int priority();
}

// Step 2: Create a Class and Apply the Annotation
class TaskManager {

    @TaskInfo(assignedTo = "Alice", priority = 1)
    public void completeTask() {
        System.out.println("Task is being completed...");
    }
}

// Step 3: Retrieve Annotation Details Using Reflection
public class CustomAnnotationExample {
    public static void main(String[] args) {
        try {
            // Get the TaskManager class
            Class<TaskManager> taskClass = TaskManager.class;

            // Get the method where the annotation is applied
            Method method = taskClass.getMethod("completeTask");

            // Check if TaskInfo annotation is present
            if (method.isAnnotationPresent(TaskInfo.class)) {
                // Retrieve the annotation
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                // Print annotation details
                System.out.println("Task Assigned To: " + taskInfo.assignedTo());
                System.out.println("Task Priority: " + taskInfo.priority());
            }

            // Call the method
            TaskManager taskManager = new TaskManager();
            taskManager.completeTask();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
