package com.capgeminitraining.day5.regex;
import java.util.*;

public class RepeatingWordsFinder{
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test repeated.";

        // Convert text to lowercase and split into words
        String[] words = text.toLowerCase().split("\\s+");

        // Using HashMap to store word frequencies
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", ""); // Remove punctuation
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Print words that appear more than once
        System.out.println("Repeated Words:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}
