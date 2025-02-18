package com.tit.csvdatahandling.basicproblems.writedatatocsvfile;

import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToCsvFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\employee.csv";
        //Try with Resoures
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write("ID,Name,Department,Salary\n");
            writer.write("07,Aditya,IT,100000\n");
            writer.write("18,Ankit,IT,100000\n");
            writer.write("01,Aadarsh,IT,120000\n");
            writer.write("34,Darshan,IT,100000\n");
            writer.write("88,Rajveer,IT,100000\n");
            System.out.println("CSV file written successfully");

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
