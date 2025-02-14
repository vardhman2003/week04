package com.capgeminitraining.day4;

import java.io.*;

public class ReadFile{
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "info.txt";

        // Try-with-resources to handle file reading and automatic closing
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Read and print the first line of the file
            String firstLine = reader.readLine();
            System.out.println(firstLine);
        } catch (IOException e) {
            // Handle file not found or other I/O exceptions
            System.out.println("Error reading file "+e.getMessage());


        }
    }
}