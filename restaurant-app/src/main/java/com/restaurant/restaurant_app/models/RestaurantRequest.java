package com.restaurant.restaurant_app.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantRequest {

    private String name;
    private Long mobile;
    private String address;
    private String city;
    private String state;


}
