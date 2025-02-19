package com.tit.json.iplandsensoranalyzer;

public class Main {
    public static void main(String[] args) {

        String inpiutjson = "src/main/resources/iplData.json";
        String outputjson = "src/main/resources/censoredData.json";

        String inputcsv = "src/main/resources/iplData.csv";
        String outputcsv = "src/main/resources/censoredData.csv";

        JsonProcessor.processJson(inpiutjson,outputjson);

        CsvProcessor.processCsv(inputcsv, outputcsv);

        System.out.println("Censorship applied successfully!");
    }
}
