package com.tit.csvdatahandling.basicproblems.readandcountrowsincsvfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\employee.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            int count = 0;
            String line;
            while((line = br.readLine())!=null){
                count++;
            }
            System.out.println("Number of records in file is: " + (count-1));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
