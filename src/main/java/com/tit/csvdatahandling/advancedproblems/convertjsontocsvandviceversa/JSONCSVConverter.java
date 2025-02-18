package com.tit.csvdatahandling.advancedproblems.convertjsontocsvandviceversa;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONCSVConverter {
    public static void main(String[] args) {
        String jsonFile = "src/main/resources/Student.json";
        String csvFile = "src/main/resources/Students.csv";
        String jsonOutputFile = "src/main/resources/students_converted.json";

        jsonToCSV(jsonFile, csvFile);
        csvToJSON(csvFile, jsonOutputFile);
    }

    // Convert JSON to CSV
    public static void jsonToCSV(String jsonFile, String csvFile) {
        try {
            // Read JSON file as String
            String jsonData = new String(Files.readAllBytes(Paths.get(jsonFile)));
            JSONArray jsonArray = new JSONArray(jsonData);

            try (FileWriter writer = new FileWriter(csvFile)) {
                // Write CSV header
                writer.write("ID,Name,Age,Grade\n");

                // Write data
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    writer.write(obj.getInt("id") + ","
                            + obj.getString("name") + ","
                            + obj.getInt("age") + ","
                            + obj.getString("grade") + "\n");
                }
            }

            System.out.println("JSON converted to CSV successfully!");

        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        }
    }

    // Convert CSV to JSON
    public static void csvToJSON(String csvFile, String jsonOutputFile) {
        JSONArray jsonArray = new JSONArray();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile));
             FileWriter writer = new FileWriter(jsonOutputFile)) {

            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Skip header row
                }

                // Proper CSV splitting
                String[] columns = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Handles commas inside quotes

                JSONObject obj = new JSONObject();
                obj.put("id", Integer.parseInt(columns[0].trim()));
                obj.put("name", columns[1].trim());
                obj.put("age", Integer.parseInt(columns[2].trim()));
                obj.put("grade", columns[3].trim());

                jsonArray.put(obj);
            }

            writer.write(jsonArray.toString(4));
            System.out.println("CSV converted back to JSON successfully!");

        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
