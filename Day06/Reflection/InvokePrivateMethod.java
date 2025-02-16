package com.capgeminitraining.day6.Reflection;

import java.lang.reflect.Method;

class Calculator {
    // Private method
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) {
        try {
            // Create an instance of Calculator
            Calculator calculator = new Calculator();

            // Get the Class object
            Class<?> calculatorClass = calculator.getClass();

            // Access the private method "multiply"
            Method multiplyMethod = calculatorClass.getDeclaredMethod("multiply", int.class, int.class);

            // Allow invocation of private method
            multiplyMethod.setAccessible(true);

            // Invoke the private method
            int result = (int) multiplyMethod.invoke(calculator, 5, 4);

            // Display result
            System.out.println("Result of multiply(5, 4): " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
