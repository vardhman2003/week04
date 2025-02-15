package com.capgeminitraining.day5.regex;

import java.util.regex.*;

public class DateExtract {
    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        // Regular expression for dates in dd/mm/yyyy format
        String dateRegex = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(text);

        // Using while loop to find all matches
        System.out.println("Extracted Dates:");
        while (matcher.find()) {
            System.out.println(matcher.group());  // Print each matched date
        }
    }
}
