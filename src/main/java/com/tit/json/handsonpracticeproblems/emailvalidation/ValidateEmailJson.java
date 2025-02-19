package com.tit.json.handsonpracticeproblems.emailvalidation;
package com.tit.json.validation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;

public class ValidateEmailJson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Load JSON schema from file
            FileInputStream schemaStream = new FileInputStream("src/main/resources/email-schema.json");
            JSONObject schemaJson = new JSONObject(new JSONTokener(schemaStream));
            Schema schema = SchemaLoader.load(schemaJson);

            // Read JSON data to validate
            JsonNode jsonData = objectMapper.readTree(new File("src/main/resources/student.json"));
            JSONObject jsonObject = new JSONObject(jsonData.toString());

            // Validate JSON against schema
            schema.validate(jsonObject);

            System.out.println("JSON is valid!");

        } catch (Exception e) {
            System.out.println("JSON validation failed: " + e.getMessage());
        }
    }
}
