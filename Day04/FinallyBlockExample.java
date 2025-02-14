package com.capgeminitraining.day4;

import java.util.Scanner;

public class FinallyBlockExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter num1: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter num2: ");
        int num2 = scanner.nextInt();

        try {
            int result = divide(num1, num2);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");
        } finally {
            System.out.println("Operation completed");
        }
    }

    public static int divide(int a, int b) {

        return a / b;
    }
}
