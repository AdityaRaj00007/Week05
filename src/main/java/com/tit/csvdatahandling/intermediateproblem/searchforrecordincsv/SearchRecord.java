package com.tit.csvdatahandling.intermediateproblem.searchforrecordincsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchRecord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String filePath = "C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\employee.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            System.out.println("Enter Employee Name You Want to Search: ");
            String name = input.next();
            int nameColumns = -1;
            boolean isHeader = true;
            while((line = br.readLine())!=null){
                String [] columns = line.split(",");
                if(isHeader){
                    for (int i = 0; i < columns.length; i++) {
                        if (columns[i].equalsIgnoreCase("Name")) {
                           nameColumns  = i;
                        }
                    }
                    if (nameColumns == -1) {
                        System.out.println("Name column not found!");
                        return;
                    }
                    isHeader = false;

                }
                else{
                    if(columns[nameColumns].equalsIgnoreCase(name)){
                        System.out.println(String.join("\t" , columns[2],columns[3]));
                    }
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
