package com.capgeminitraining.day5.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserNameCheck {
    public static void main(String[] args) {
        String regex = "^[a-zA-z]{1}[a-zA-Z0-9_]{4,14}+";

        Pattern pattern = Pattern.compile(regex);

        String[] userNames = {"kapil_12","new23","us","2user_"};

        for (String userName : userNames){
            Matcher matcher = pattern.matcher(userName);
            System.out.println(userName + " is Valid: " + matcher.matches());
        }
    }
}
