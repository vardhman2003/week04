package com.capgeminitraining.day5.regex;

public class SpaceReducer {
    public static void main(String[] args) {
        String input = "This  is   an  example    with multiple   spaces.";

        // Replace multiple spaces with a single space
        String output = input.replaceAll("\\s+", " ");

        // Print the modified string
        System.out.println("Modified String: " + output);
    }
}
