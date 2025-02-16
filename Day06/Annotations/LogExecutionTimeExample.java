package com.capgeminitraining.day6.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Step 1: Define the @LogExecutionTime Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@interface LogExecutionTime {}

// Step 2: Create an Interface for Sample Methods
interface Task {
    @LogExecutionTime
    void fastTask();

    @LogExecutionTime
    void slowTask();

    void normalTask(); // Not annotated
}

// Step 3: Implement the Interface
class TaskImpl implements Task {
    public void fastTask() {
        System.out.println("Executing fast task...");
    }

    public void slowTask() {
        System.out.println("Executing slow task...");
        try {
            Thread.sleep(500); // Simulating a slow operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void normalTask() {
        System.out.println("Executing normal task...");
    }
}

// Step 4: Create a Dynamic Proxy to Measure Execution Time
class ExecutionTimeProxy implements InvocationHandler {
    private final Object target;

    public ExecutionTimeProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime(); // Start time
            Object result = method.invoke(target, args); // Invoke original method
            long endTime = System.nanoTime(); // End time
            System.out.println(method.getName() + " executed in " + (endTime - startTime) / 1_000_000.0 + " ms");
            return result;
        } else {
            return method.invoke(target, args); // Directly invoke if annotation is not present
        }
    }

    // Method to create a proxy instance
    public static <T> T createProxy(T obj, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new ExecutionTimeProxy(obj)
        );
    }
}

// Step 5: Test the Proxy and Annotation
public class LogExecutionTimeExample {
    public static void main(String[] args) {
        // Create a proxy instance of Task
        Task task = ExecutionTimeProxy.createProxy(new TaskImpl(), Task.class);

        // Execute methods and measure time where annotated
        task.fastTask();
        task.slowTask();
        task.normalTask(); // No execution time logging
    }
}
