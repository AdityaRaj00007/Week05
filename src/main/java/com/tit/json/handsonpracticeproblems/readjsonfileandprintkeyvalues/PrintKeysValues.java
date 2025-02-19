package com.tit.json.handsonpracticeproblems.readjsonfileandprintkeyvalues;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Paths;
import java.util.Map;

public class PrintKeysValues {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            File jsonFile = Paths.get("src/main/resources/car.json").toFile();
            Map<String,Object> jsonMap = objectMapper.readValue(jsonFile, Map.class);
            for(var entry : jsonMap.entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
