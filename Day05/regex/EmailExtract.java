package com.capgeminitraining.day5.regex;

import java.util.regex.*;

public class EmailExtract {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org for more details. Also, reach out at test123@gmail.com.";

        // Define the regex pattern for email extraction
        String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(text);

        // Using while loop to find all matches
        System.out.println("Extracted Emails:");
        while (matcher.find()) {
            System.out.println(matcher.group());  // Print each matched email
        }
    }
}
