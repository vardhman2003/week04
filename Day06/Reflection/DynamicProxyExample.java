package com.capgeminitraining.day6.Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Step 1: Define an Interface
interface Greeting {
    void sayHello(String name);
}

// Step 2: Implement the Interface
class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// Step 3: Create a Dynamic Proxy Handler
class LoggingHandler implements InvocationHandler {
    private final Object target; // The real object

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log method call
        System.out.println("Executing method: " + method.getName());

        // Execute the actual method
        return method.invoke(target, args);
    }
}

// Step 4: Create a Proxy Instance
public class DynamicProxyExample {
    public static void main(String[] args) {
        // Create the original object
        Greeting originalGreeting = new GreetingImpl();

        // Create a dynamic proxy for the Greeting interface
        Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(), // ClassLoader
                new Class<?>[]{Greeting.class},  // Interfaces to implement
                new LoggingHandler(originalGreeting) // InvocationHandler
        );

        // Call method on the proxy instance
        proxyGreeting.sayHello("Alice");
    }
}
