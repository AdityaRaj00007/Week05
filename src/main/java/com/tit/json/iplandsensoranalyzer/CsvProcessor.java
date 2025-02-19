package com.tit.json.iplandsensoranalyzer;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class CsvProcessor {
    public static void processCsv(String inputFile, String outputFile) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));
            List<String> censoredLines = lines.stream()
                    .map(Utils::censorCsvLine)
                    .collect(Collectors.toList());

            Files.write(Paths.get(outputFile), censoredLines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
