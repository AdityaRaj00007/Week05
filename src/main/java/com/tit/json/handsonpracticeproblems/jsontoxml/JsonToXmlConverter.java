package com.tit.json.handsonpracticeproblems.jsontoxml;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            JSONObject json = new JSONObject(objectMapper.readTree(new File("src/main/resources/car.json")).toString());
            // Convert JSON to XML
            String xmlData = XML.toString(json, "Car");
            // Print XML output
            System.out.println(xmlData);

        } catch (IOException e) {
            System.out.println("Error processing JSON file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
