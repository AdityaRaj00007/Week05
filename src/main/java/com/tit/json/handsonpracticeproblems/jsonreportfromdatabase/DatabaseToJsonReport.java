package com.tit.json.handsonpracticeproblems.jsonreportfromdatabase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.sql.*;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "aditya07";
        String password = "7828839";

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode studentArray = objectMapper.createArrayNode();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, age, email FROM students")) {

            while (rs.next()) {
                ObjectNode student = objectMapper.createObjectNode();
                student.put("id", rs.getInt("id"));
                student.put("name", rs.getString("name"));
                student.put("age", rs.getInt("age"));
                student.put("email", rs.getString("email"));
                studentArray.add(student);
            }

            // Write JSON to file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/studentDB.json"), studentArray);

            System.out.println("JSON Report Generated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
