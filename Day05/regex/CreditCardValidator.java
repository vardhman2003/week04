package com.capgeminitraining.day5.regex;

import java.util.regex.*;

public class CreditCardValidator{
    public static void main(String[] args) {
        String[] cardNumbers = {"4539876543211234", "5298765432109876", "6123456789012345", "4111111111111111"};

        // Regular expression for Visa (starts with 4, 16 digits) and MasterCard (starts with 5, 16 digits)
        String cardRegex = "^(4\\d{15}|5\\d{15})$";

        for (int i = 0; i < cardNumbers.length; i++) {
            // Check if the card number matches the pattern
            boolean isValid = Pattern.matches(cardRegex, cardNumbers[i]);

            // Print the result
            if (isValid) {
                System.out.println(cardNumbers[i] + " is a valid Visa or MasterCard number.");
            } else {
                System.out.println(cardNumbers[i] + " is NOT a valid Visa or MasterCard number.");
            }
        }
    }
}
