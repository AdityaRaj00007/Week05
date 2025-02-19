package com.tit.json.iplandsensoranalyzer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Utils {
    public static void censorMatch(JsonNode match) {
        ((ObjectNode) match).put("team1", maskName(match.get("team1").asText()));
        ((ObjectNode) match).put("team2", maskName(match.get("team2").asText()));
        ((ObjectNode) match).put("player_of_match", "REDACTED");
    }

    public static String censorCsvLine(String line) {
        String[] parts = line.split(",");
        if (parts.length > 6) {
            parts[1] = maskName(parts[1]);
            parts[2] = maskName(parts[2]);
            parts[6] = "REDACTED";
        }
        return String.join(",", parts);
    }

    private static String maskName(String name) {
        return name.split(" ")[0] + " ***";
    }
}
