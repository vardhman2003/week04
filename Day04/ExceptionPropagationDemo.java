package com.capgeminitraining.day4;

public class ExceptionPropagationDemo {
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }

    public static void method2() {
        method1();
    }

    public static void method1()throws ArithmeticException  {
        if(10/0==0)
       throw new ArithmeticException("10 / 0 causes an error");
    }
}
