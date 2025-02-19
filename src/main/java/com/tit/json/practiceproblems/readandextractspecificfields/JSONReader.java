package com.tit.json.practiceproblems.readandextractspecificfields;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

class Student {
    public String name;
    public String email;
    public int age;

    // Default constructor required for Jackson
    public Student() {}
}

public class JSONReader {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File jsonFile = Paths.get("src/main/resources/student.json").toFile();

            if (!jsonFile.exists()) {
                System.out.println("Error: JSON file not found!");
                return;
            }
            List<Student> students = Arrays.asList(objectMapper.readValue(jsonFile, Student[].class));

            for (Student student : students) {
                System.out.println("Name: " + student.name);
                System.out.println("Email: " + student.email);
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error reading JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

// or
//public class JSONReader {
//    public static void main(String[] args) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            File jsonFile = Paths.get("src/main/resources/student.json").toFile();
//
//            if (!jsonFile.exists()) {
//                System.out.println("Error: JSON file not found!");
//                return;
//            }
//
//            // Read JSON file into JsonNode
//            JsonNode jsonNode = objectMapper.readTree(jsonFile);
//
//            // Extract fields from JSON
//            String name = jsonNode.has("name") ? jsonNode.get("name").asText() : "N/A";
//            String email = jsonNode.has("email") ? jsonNode.get("email").asText() : "N/A";
//
//            System.out.println("name: " + name);
//            System.out.println("email: " + email);
//
//        } catch (IOException e) {
//            System.out.println("Error reading JSON: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}

