package com.tit.csvdatahandling.intermediateproblem.sortcsvrecordsbycolumn;

import java.io.*;
import java.util.*;

public class SortCSVRecords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\employee.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String[]> employees = new ArrayList<>();
            String header = br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                employees.add(columns);
            }

            Collections.sort(employees, new Comparator<String[]>() {
                @Override
                public int compare(String[] a, String[] b) {
                    int salaryA = Integer.parseInt(a[3].trim());
                    int salaryB = Integer.parseInt(b[3].trim());
                    return Integer.compare(salaryB, salaryA);
                }
            });
            System.out.println("\nTop 5 Highest-Paid Employees:");
            System.out.println(header); // Print header
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                System.out.println(String.join("\t", employees.get(i)));
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
