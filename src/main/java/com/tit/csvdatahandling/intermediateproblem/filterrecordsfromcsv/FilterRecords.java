package com.tit.csvdatahandling.intermediateproblem.filterrecordsfromcsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        String filePath ="C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\student.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = br.readLine())!=null){
                String[] columns = line.split(",");
                if (!columns[3].matches("\\d+")) {
                    System.out.println(String.join("\t" , columns));
                }
               else if(Integer.parseInt(columns[3])>80){
                    System.out.println(String.join("\t" , columns));
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
