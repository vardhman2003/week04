package com.capgeminitraining.day4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("Enter num1: ");
            int num1 = input.nextInt();

            System.out.println("Enter num2: ");
            int num2 = input.nextInt();

            int result = num1/num2;
            System.out.println("Result : "+result);
        }
        catch (ArithmeticException e){
            System.out.println("Divisible by 0 is not allowed");
        }catch (InputMismatchException e){
            System.out.println("Enter only numeric value is allowed ");
        }
    }
}
