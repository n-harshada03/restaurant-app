package com.restaurant.restaurant_app.models;


import com.restaurant.restaurant_app.entity.Restaurant;
import com.restaurant.restaurant_app.entity.RestaurantOwner;
import lombok.Data;

@Data
public class RestaurantRequest {

//    private int ownerId;
    private String ownerFirstName;
    private String ownerLastName;
    private String email;

    private String restaurantName;
    private Restaurant.RestroType restroType;
    private String speciality;
    private String serviceType;
    private String openingHour;
    private String closingHour;
    private String logo;


    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;


    private String mobileNo;

    private String foodLicense;

}
