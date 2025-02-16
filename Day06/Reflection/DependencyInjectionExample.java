package com.capgeminitraining.day6.Reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @Inject annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

// Step 2: Define Service Classes
class ServiceA {
    public void execute() {
        System.out.println("ServiceA executing...");
    }
}

class ServiceB {
    public void execute() {
        System.out.println("ServiceB executing...");
    }
}

// Step 3: Define a Consumer Class with Dependencies
class Consumer {
    @Inject
    private ServiceA serviceA;

    @Inject
    private ServiceB serviceB;

    public void useServices() {
        serviceA.execute();
        serviceB.execute();
    }
}

// Step 4: Implement a Simple DI Container
class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    // Register and instantiate classes
    public void register(Class<?> clazz) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        instances.put(clazz, instance);
    }

    // Inject dependencies
    public void injectDependencies(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true); // Allow access to private fields
                Object dependency = instances.get(field.getType());
                if (dependency == null) {
                    dependency = field.getType().getDeclaredConstructor().newInstance();
                    instances.put(field.getType(), dependency);
                }
                field.set(obj, dependency);
            }
        }
    }
}

// Step 5: Demonstrate Dependency Injection
public class DependencyInjectionExample {
    public static void main(String[] args) {
        try {
            DIContainer container = new DIContainer();

            // Register services
            container.register(ServiceA.class);
            container.register(ServiceB.class);

            // Create Consumer instance and inject dependencies
            Consumer consumer = new Consumer();
            container.injectDependencies(consumer);

            // Use the injected services
            consumer.useServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
