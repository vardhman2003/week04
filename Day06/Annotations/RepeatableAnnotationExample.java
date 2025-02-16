package com.capgeminitraining.day6.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;

// Step 1: Define the Containing Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

// Step 2: Define the Repeatable Annotation
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class) // Enables multiple applications
@interface BugReport {
    String description();
    String reportedBy();
}

// Step 3: Apply the Annotation Multiple Times on a Method
class SoftwareModule {

    @BugReport(description = "Null pointer exception on edge cases", reportedBy = "Alice")
    @BugReport(description = "Memory leak when processing large data", reportedBy = "Bob")
    public void processData() {
        System.out.println("Processing data...");
    }
}

// Step 4: Retrieve and Print All Bug Reports Using Reflection
public class RepeatableAnnotationExample {
    public static void main(String[] args) {
        try {
            // Get the SoftwareModule class
            Class<SoftwareModule> clazz = SoftwareModule.class;

            // Get the method where the annotations are applied
            Method method = clazz.getMethod("processData");

            // Retrieve multiple annotations
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);

                System.out.println("Bug Reports:");
                for (BugReport bug : bugReports.value()) {
                    System.out.println("- " + bug.description() + " (Reported by: " + bug.reportedBy() + ")");
                }
            }

            // Call the method
            SoftwareModule module = new SoftwareModule();
            module.processData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
