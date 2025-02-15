package com.capgeminitraining.day5.regex;

import java.util.regex.*;

public class LinkExtractor{
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info visit https://github.com/kapiltiwarii/WEEK_FOUR ";

        // Define the regex pattern for URL extraction
        String urlRegex = "https?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/\\S*)?";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(text);

        // Using while loop to find all matches
        System.out.println("Extracted Links:");
        while (matcher.find()) {
            System.out.println(matcher.group());  // Print each matched URL
        }
    }
}
