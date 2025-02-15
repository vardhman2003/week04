package com.capgeminitraining.day5.regex;

import java.util.regex.*;

public class LanguageExtractor {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // Regular expression to match programming language names
        String languageRegex = "\\b(JavaScript|Java|Python|Go)\\b";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(languageRegex);
        Matcher matcher = pattern.matcher(text);

        // Using while loop to find all matches
        System.out.println("Extracted Programming Languages:");
        while (matcher.find()) {
            System.out.println(matcher.group());  // Print each matched language
        }
    }
}
