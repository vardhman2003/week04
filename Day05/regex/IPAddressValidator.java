package com.capgeminitraining.day5.regex;

import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        String[] ip = {"192.168.1.1","256.300.1.1","172.16.254.1","192.168.1"}; // Change this IP to test different cases

        // Regular expression for a valid IPv4 address
        String ipv4Regex = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";

        for(int i = 0;i<ip.length;i++) {
            // Check if the IP matches the pattern
            boolean isValid = Pattern.matches(ipv4Regex, ip[i]);
            // Print the result
            if (isValid) {
                System.out.println(ip[i] + " is a valid IPv4 address.");
            } else {
                System.out.println(ip[i] + " is NOT a valid IPv4 address.");
            }
        }
    }
}
