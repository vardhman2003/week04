package com.capgeminitraining.day5.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidHexColour {
    public static void main(String[] args) {

        String regex = "^[#]{1}[0-9a-fA-F]{6}$";

        Pattern pattern = Pattern.compile(regex);

        String[] colourCodes = {"#FFA500", "#ff4500", "ff4000", "#A4590"};

        for(String colourCode : colourCodes)
        {
            Matcher matcher = pattern.matcher(colourCode);
            System.out.println(colourCode + " is Valid: " + matcher.matches());
        }
    }
}
