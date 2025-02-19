package com.tit.json.practiceproblems.filterjsonrecords;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilterRecords {
    public static void main(String[] args) {
        File jsonFile = Paths.get("src/main/resources/student.json").toFile();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonFile);
            if(!jsonNode.isArray()){
                System.out.println("Expected JSON array");
            }
            List<JsonNode> filerStudents = new ArrayList<>();
            for(JsonNode student : jsonNode){
                if(student.has("age")&&student.get("age").asInt()>25){
                    filerStudents.add(student);
                }
            }
            String filteredJSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filerStudents);
            System.out.println(filteredJSON);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
