package com.capgeminitraining.day5.regex;

import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {
        String[] ssnList = {"123-45-6789", "123456789", "987-65-4321", "000-12-3456", "123-45-678"};

        // Regular expression for a valid SSN (###-##-#### format)
        String ssnRegex = "^(?!000|666\\d{2})\\d{3}-(?!00)\\d{2}-(?!0000)\\d{4}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(ssnRegex);

        for (String ssn : ssnList) {
            // Check if the SSN matches the pattern
            Matcher matcher = pattern.matcher(ssn);
            if (matcher.matches()) {
                System.out.println(ssn + "\" is valid");
            } else {
                System.out.println("\""+ssn + "\" is invalid");
            }
        }
    }
}
