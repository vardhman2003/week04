package com.capgeminitraining.day4;

import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Accept array size and elements
            System.out.print(" size of the array: ");
            int size = scanner.nextInt();
            int[] array = new int[size];

            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
               array[i] = scanner.nextInt();
            }

            // Accept index to retrieve value
            System.out.print("retrieve value: ");
            int index = scanner.nextInt();

            // Print value at the specified index
            System.out.println("Value at index " + index + ": " + array[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (Exception e){
            System.out.println("Invalid Input! ");
        }
    }
}
