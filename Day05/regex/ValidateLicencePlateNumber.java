package com.capgeminitraining.day5.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLicencePlateNumber {
    public static void main(String[] args) {

    String regex = "^[A-Z]{2}[0-9]{4}$";

    Pattern pattern = Pattern.compile(regex);

    String[] licenceNumbers = {"MP3455", "MP", "4646", "JK6788"};

        for(String licenceNumber :licenceNumbers)
    {
        Matcher matcher = pattern.matcher(licenceNumber);
        System.out.println(licenceNumber + " is Valid: " + matcher.matches());
    }
}
}
