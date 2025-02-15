package com.capgeminitraining.day5.junit;

public class CalculatorException {
    // Method to perform division, throws ArithmeticException if b is zero
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
