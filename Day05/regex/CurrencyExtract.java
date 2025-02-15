package com.capgeminitraining.day5.regex;

import java.util.regex.*;

public class CurrencyExtract{
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        // Regular expression to match currency values (with or without a dollar sign)
        String currencyRegex = "\\$?\\d+\\.\\d{2}";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(currencyRegex);
        Matcher matcher = pattern.matcher(text);

        // Using while loop to find all matches
        System.out.println("Extracted Currency Values:");
        while (matcher.find()) {
            System.out.println(matcher.group());  // Print each matched currency value
        }
    }
}
