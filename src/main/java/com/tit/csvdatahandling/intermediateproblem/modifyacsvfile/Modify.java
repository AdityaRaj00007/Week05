package com.tit.csvdatahandling.intermediateproblem.modifyacsvfile;
import java.io.*;
import java.util.Scanner;

public class Modify {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String filePath = "C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\employee.csv";
        String tempFile = "C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\employeeUpdated.csv";

        System.out.print("Enter the Department: ");
        String department = input.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            int departmentColumn = -1;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                if (isHeader) {
                    for (int i = 0; i < columns.length; i++) {
                        if (columns[i].trim().equalsIgnoreCase("Department")) {
                            departmentColumn = i;
                            break;
                        }
                    }
                    if (departmentColumn == -1) {
                        System.out.println("Department column not found.");
                        return;
                    }

                    writer.write(String.join(",", columns));
                    writer.newLine();  // Ensure the header is written properly
                    isHeader = false;
                } else {
                    if (columns.length > departmentColumn && columns[departmentColumn].equalsIgnoreCase(department)) {
                        int currentSalary = Integer.parseInt(columns[3].trim());
                        int updatedSalary = (int) (0.1f * currentSalary) + currentSalary;
                        columns[3] = String.valueOf(updatedSalary);
                    }
                    writer.write(String.join(",", columns));
                    writer.newLine();
                }
            }

            System.out.println("File updated successfully.");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
