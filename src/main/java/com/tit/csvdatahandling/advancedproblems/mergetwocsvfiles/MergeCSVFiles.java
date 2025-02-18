package com.tit.csvdatahandling.advancedproblems.mergetwocsvfiles;
import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\Student1.csv"; // ID, Name, Age
        String file2 = "C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\Student2.csv"; // ID, Marks, Grade
        String outputFile = "C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\MergedStudent.csv.";

        Map<String, String[]> studentData = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            String header1 = br1.readLine();
            String line;
            while ((line = br1.readLine()) != null) {
                String[] columns = line.split(",");
                studentData.put(columns[0], columns);
            }
        } catch (IOException e) {
            System.out.println("Error reading file1: " + e.getMessage());
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
            String header2 = br2.readLine();
            String line;
            while ((line = br2.readLine()) != null) {
                String[] columns = line.split(",");
                if (studentData.containsKey(columns[0])) {
                    String[] existingData = studentData.get(columns[0]);
                    studentData.put(columns[0], new String[]{existingData[0], existingData[1], existingData[2], columns[1], columns[2]});
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file2: " + e.getMessage());
        }

        // Write merged data to a new file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("ID,Name,Age,Marks,Grade\n");
            for (String[] details : studentData.values()) {
                writer.write(String.join(",", details) + "\n");
            }
            System.out.println("Merged file created successfully: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing merged file: " + e.getMessage());
        }
    }
}
