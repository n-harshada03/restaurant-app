package com.restaurant.restaurant_app.models;


import lombok.Data;

@Data
public class RestaurantRequest {

    private String restroName;
    private String restroType;
    private String serviceType;
    private String speciality;
    private String opening_hour;
    private String closing_hour;

}
