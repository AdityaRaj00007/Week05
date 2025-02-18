package com.tit.csvdatahandling.basicproblems.readcsvfileandprintdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndPrintData {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\student.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine())!=null){
                String[] columns = line.split(",");
                System.out.println(columns[0] + "\t" +  columns[1] +"\t"+ columns[2] +"\t"+ columns[3]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
