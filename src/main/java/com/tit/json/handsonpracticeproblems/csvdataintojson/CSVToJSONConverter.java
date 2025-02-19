package com.tit.json.handsonpracticeproblems.csvdataintojson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;
import java.util.Map;

public class CSVToJSONConverter {
    public static void main(String[] args) {
        try {
            File csvFile = new File("src/main/resources/employee.csv"); // Update with your file path
            File jsonFile = new File("src/main/resources/employee.json");

            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();

            // Read CSV into a List of Maps (Each row is a Map<String, String>)
            CsvMapper csvMapper = new CsvMapper();
            List<Object> data = csvMapper.readerFor(Map.class)
                    .with(csvSchema)
                    .readValues(csvFile)
                    .readAll();

            // Convert List<Map> to JSON and save it to a file
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, data);

            System.out.println("CSV successfully converted to JSON: " + jsonFile.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
