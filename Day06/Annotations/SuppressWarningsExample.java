package com.capgeminitraining.day6.Annotations;

import java.util.ArrayList;

public class SuppressWarningsExample {

    @SuppressWarnings("unchecked") // Suppresses unchecked warning
    public static void main(String[] args) {
        // Creating an ArrayList without generics
        ArrayList list = new ArrayList(); // Warning without @SuppressWarnings
        list.add("Hello");
        list.add(100); // Mixing different types

        // Retrieving values (Need explicit casting)
        String str = (String) list.get(0);
        Integer num = (Integer) list.get(1);

        // Printing the values
        System.out.println("String value: " + str);
        System.out.println("Integer value: " + num);
    }
}
