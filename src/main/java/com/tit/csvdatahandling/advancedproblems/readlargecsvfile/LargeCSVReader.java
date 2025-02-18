package com.tit.csvdatahandling.advancedproblems.readlargecsvfile;
import java.io.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\sample_data.csv";
        int batchSize = 100;
        processCSVInChunks(filePath, batchSize);
    }

    public static void processCSVInChunks(String filePath, int batchSize) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                count++;

                if (count % batchSize == 0) {
                    System.out.println("Processed records: " + count);
                }
            }

            System.out.println("Total records processed: " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
