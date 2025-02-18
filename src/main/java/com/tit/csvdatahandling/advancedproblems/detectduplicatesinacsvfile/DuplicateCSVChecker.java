package com.tit.csvdatahandling.advancedproblems.detectduplicatesinacsvfile;
import java.io.*;
import java.util.*;

public class DuplicateCSVChecker {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\sample_data.csv";
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Set<String> idSet = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                // Skip header
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] values = line.split(",");
                String id = values[0].trim();

                if (idSet.contains(id)) {
                    duplicateRecords.add(line);
                } else {
                    idSet.add(id);
                }
            }
            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate records found:");
                for (String record : duplicateRecords) {
                    System.out.println(record);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
