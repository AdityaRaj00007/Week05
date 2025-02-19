package com.tit.json.practiceproblems.validatejsonstructure;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class ValidateJSON {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
        File jsonFile = Paths.get("src/main/resources/student.json").toFile();
            JsonNode jsonNode = objectMapper.readTree(jsonFile);
            System.out.println("JSON is Valid: " + jsonNode.toPrettyString());
        } catch (IOException e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}
