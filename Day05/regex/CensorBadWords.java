package com.capgeminitraining.day5.regex;

public class CensorBadWords{
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";

        // List of bad words to censor
        String[] badWords = {"damn", "stupid"};

        // Replace each bad word with ****
        for (String badWord : badWords) {
            input = input.replaceAll("(?i)\\b" + badWord + "\\b", "****");
        }

        // Print the censored sentence
        System.out.println("Censored Output: " + input);
    }
}
