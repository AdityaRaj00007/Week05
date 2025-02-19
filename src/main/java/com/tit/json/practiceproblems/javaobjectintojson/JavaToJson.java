package com.tit.json.practiceproblems.convertjavaobjectintojson;

import org.json.JSONObject;

public class JavaToJson {
    public static void main(String[] args) {
        Car car = new Car("Honda" , "Xyz" , 2025 , 2000000);
        JSONObject jsoncar = new JSONObject();
        jsoncar.put("brand" , car.brand);
        jsoncar.put("model" , car.model);
        jsoncar.put("year" , car.year);
        jsoncar.put("price" , car.price);

        System.out.println(jsoncar.toString(1));

    }
}
