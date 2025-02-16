package com.capgeminitraining.day6.Reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    // Methods to perform arithmetic operations
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try {
            // Create an instance of MathOperations
            MathOperations mathOps = new MathOperations();

            // Get the Class object
            Class<?> mathClass = mathOps.getClass();

            // Take user input for method name
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            // Get user input for parameters
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            scanner.close();

            // Get the method dynamically based on user input
            Method method = mathClass.getMethod(methodName, int.class, int.class);

            // Invoke the method dynamically
            int result = (int) method.invoke(mathOps, num1, num2);

            // Display result
            System.out.println("Result: " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Error: Method not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
