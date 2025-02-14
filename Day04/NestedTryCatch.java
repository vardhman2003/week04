package com.capgeminitraining.day4;

import java.util.Scanner;

public class NestedTryCatch{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {15,25,27,12,3}; // Sample array
        System.out.print("Enter index: ");
        int index = scanner.nextInt();
        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();
        try {
            try {
                int value = array[index]; // Attempt to access index
                try {
                    int result = value / divisor; // Attempt division
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } finally {
            System.out.println("Operation completed.");
        }
    }
}
