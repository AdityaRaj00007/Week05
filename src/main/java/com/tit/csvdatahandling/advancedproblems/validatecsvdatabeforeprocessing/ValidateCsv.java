package com.tit.csvdatahandling.advancedproblems.validatecsvdatabeforeprocessing;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ValidateCsv {
    public static void main(String[] args) {
        int emailColumn = -1;
        boolean isHeader = true;
        int phoneNoColumn = -1;
        String regexPhoneNo = "\\d{10}";
        String regexEmail = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        String filePath = "C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\EmployeeInformation.csv";

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] columns;
            while ((columns = csvReader.readNext()) != null) {
                if (isHeader) {
                    // Find the index of Email and Phone columns
                    for (int i = 0; i < columns.length; i++) {
                        if (columns[i].equalsIgnoreCase("Email")) {
                            emailColumn = i;
                        }
                        if (columns[i].equalsIgnoreCase("Phone")) {
                            phoneNoColumn = i;
                        }
                    }
                    if (emailColumn == -1) {
                        System.out.println("Email column not found!");
                        return;
                    }
                    if (phoneNoColumn == -1) {
                        System.out.println("Phone No column not found!");
                        return;
                    }
                    isHeader = false;
                } else {
                    // Validate Email and Phone Number
                    boolean isEmailValid = columns[emailColumn].trim().matches(regexEmail);
                    boolean isPhoneValid = columns[phoneNoColumn].trim().matches(regexPhoneNo);

                    if (!isEmailValid) {
                        System.out.println("Invalid email for: " + columns[1]);
                    }
                    if (!isPhoneValid) {
                        System.out.println("Invalid phone number for: " + columns[1]);
                    }
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
