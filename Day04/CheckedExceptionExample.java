package com.capgeminitraining.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionExample {
    public static void main(String[] args){

        String filePath = "C:\\backup\\Week04\\Exceptions\\src\\main\\java\\com\\capgeminitraining\\day4\\data.txt";

        try(FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr)){
            String line ;
            while ((line= br.readLine()) != null ){
                System.out.println(line);
            }
        }
        catch (IOException e){
            System.out.println("File not found :" + e.getMessage() );
        }

}
}