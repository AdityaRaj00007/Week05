package com.tit.json.handsonpracticeproblems.mergetwojsonintosinglejson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class MergeJSONFiles {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read first JSON file
            JsonNode json1 = objectMapper.readTree(new File("src/main/resources/file1.json"));
            // Read second JSON file
            JsonNode json2 = objectMapper.readTree(new File("src/main/resources/file2.json"));
            // Merge JSON objects
            JsonNode mergedJson = mergeJson(json1, json2);
            // Write merged JSON to a new file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/merged.json"), mergedJson);

            System.out.println("Merged JSON successfully written to merged.json");

        } catch (IOException e) {
            System.out.println("Error processing JSON files: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static JsonNode mergeJson(JsonNode mainNode, JsonNode updateNode) {
        ObjectMapper objectMapper = new ObjectMapper();
        com.fasterxml.jackson.databind.node.ObjectNode mergedNode = objectMapper.createObjectNode();

        if (mainNode.isObject()) {
            mergedNode.setAll((com.fasterxml.jackson.databind.node.ObjectNode) mainNode);
        }
        if (updateNode.isObject()) {
            mergedNode.setAll((com.fasterxml.jackson.databind.node.ObjectNode) updateNode);
        }

        return mergedNode;
    }
}
