package com.restaurant.restaurant_app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponse {

    private String restroName;
    private String restroType;
    private String serviceType;
    private String speciality;
    private String opening_hour;
    private String closing_hour;
}
