package com.tit.csvdatahandling.advancedproblems.convertcsvdataintojavaobjects;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBean;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvToObject {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\rajgu\\OneDrive\\Desktop\\Week05\\Day01_CSV-Data-Handling\\src\\main\\resources\\student.csv";
        try(FileReader reader = new FileReader(filePath)){
            CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader).withType(Student.class).withIgnoreLeadingWhiteSpace(true).build();
            List<Student> students = csvToBean.parse();
            for(Student student : students){
                System.out.println(student.getName() + " has " + student.getMarks() + " Marks");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
