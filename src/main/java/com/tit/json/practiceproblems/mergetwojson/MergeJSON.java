package com.tit.json.practiceproblems.mergetwojson;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class MergeJSON {
    public static void main(String[] args) {
        JSONObject json1 = new JSONObject();
        json1.put("name", "Aditya");
        json1.put("age", 22);
        System.out.println(json1.toString(1));

        JSONObject json2 = new JSONObject();
        json2.put("city", "Shahdol");
        json2.put("pincode", 484001);
        System.out.println(json2.toString(1));

        for(String key : json2.keySet()){
            json1.put(key , json2.get(key));
        }
        System.out.println("Merged JSON: " + json1.toString(1));

    }
}
