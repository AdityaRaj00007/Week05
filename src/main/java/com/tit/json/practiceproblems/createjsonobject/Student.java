package com.tit.json.practiceproblems.createjsonobject;
import org.json.*;
public class Student {
    public static void main(String[] args) {
        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Chemistry");
        subjects.put("Bio");

        JSONObject student = new JSONObject();
        student.put("name" , "Aditya");
        student.put("age" , 22);
        student.put("subjects" , subjects);

        System.out.println(student.toString(1));
    }
}
