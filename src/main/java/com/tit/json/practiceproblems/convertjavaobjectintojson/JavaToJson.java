package com.tit.json.practiceproblems.convertjavaobjectintojson;

import org.json.JSONObject;

class Car{
   String brand;
   String model;
   int year;
   double price;
   Car(String brand , String model , int year , double price){
       this.brand = brand;
       this.model = model;
       this.year = year;
       this.price = price;
   }
}
public class JavaToJson {
    public static void main(String[] args) {
        Car car = new Car("Honda" , "Xyz" , 2025 , 2000000);
        JSONObject jsoncar = new JSONObject();
        jsoncar.put("brand" , car.brand);
        jsoncar.put("model" , car.model);
        jsoncar.put("year" , 2025);
        jsoncar.put("price" , car.price);

        System.out.println(jsoncar.toString(1));
    }
}
