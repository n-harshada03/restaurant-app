package com.restaurant.restaurant_app.models;


import com.restaurant.restaurant_app.entity.Restaurant;
import com.restaurant.restaurant_app.entity.RestaurantOwner;
import lombok.Data;

@Data
public class RestaurantRequest {

    private String restaurantName;
    private Restaurant.RestroType restroType;
    private String speciality;
    private String serviceType;
    private String openingHour;
    private String closingHour;
    private String logo;

    private String username;
    private String ownerFirstName;
    private String ownerLastName;
    private String email;

    private RestaurantAddressRequest address;
    private RestaurantContactRequest contact;
    private RestaurantDocumentRequest legalDocuments;

//    private String addressLine1;
//    private String addressLine2;
//    private String city;
//    private String state;
//    private String country;


//    private String mobileNo;

//    private String foodLicense;

}
