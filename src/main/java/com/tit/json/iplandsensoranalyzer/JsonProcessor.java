package com.tit.json.iplandsensoranalyzer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;

public class JsonProcessor {
    public static void processJson(String inputFile, String outputFile) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new File(inputFile));

            for (JsonNode match : root) {
                Utils.censorMatch(match);
            }

            mapper.writeValue(new File(outputFile), root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
