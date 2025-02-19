package com.tit.json.handsonpracticeproblems.listofjavaobjectstojsonarray;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.List;

class Car{
    public String brand;
    public String model;
    public int year;
    public double price;
    public Car(String brand, String model, int year, double price){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }
}
public class ListToJSON {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Honda", "Civic", 2023, 25000));
        cars.add(new Car("Toyota", "Corolla", 2022, 22000));
        cars.add(new Car("Tesla", "Model 3", 2024, 45000));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonArray = objectMapper.writeValueAsString(cars);
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(jsonArray);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
