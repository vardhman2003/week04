package com.capgeminitraining.day6.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @CacheResult Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@interface CacheResult {}

// Step 2: Create a Caching System Using Reflection
class CacheHandler {
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invokeCachedMethod(Object obj, String methodName, Object... args) {
        try {
            // Create a unique key for caching based on method name and arguments
            String key = methodName + "(";
            for (Object arg : args) {
                key += arg.toString() + ",";
            }
            key = key.endsWith(",") ? key.substring(0, key.length() - 1) : key;
            key += ")";

            // Return cached result if available
            if (cache.containsKey(key)) {
                System.out.println("Returning cached result for: " + key);
                return cache.get(key);
            }

            // Find the method with matching parameters
            Method method = null;
            for (Method m : obj.getClass().getDeclaredMethods()) {
                if (m.getName().equals(methodName) && m.isAnnotationPresent(CacheResult.class)) {
                    method = m;
                    break;
                }
            }

            if (method == null) {
                throw new NoSuchMethodException("Method not found or not annotated with @CacheResult");
            }

            method.setAccessible(true);
            Object result = method.invoke(obj, args);

            // Store result in cache
            cache.put(key, result);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

// Step 3: Create a Computationally Expensive Method
class ExpensiveOperations {

    @CacheResult // Enable caching for this method
    public int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

// Step 4: Test the Caching System
public class CacheResultExample {
    public static void main(String[] args) {
        ExpensiveOperations operations = new ExpensiveOperations();

        // First call (computes and stores result)
        System.out.println("Computing Fibonacci(10): " + CacheHandler.invokeCachedMethod(operations, "fibonacci", 10));

        // Second call (retrieves from cache)
        System.out.println("Computing Fibonacci(10) again: " + CacheHandler.invokeCachedMethod(operations, "fibonacci", 10));

        // Another unique input (new computation)
        System.out.println("Computing Fibonacci(8): " + CacheHandler.invokeCachedMethod(operations, "fibonacci", 8));
    }
}
