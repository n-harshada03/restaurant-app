package com.restaurant.restaurant_app.service.impl;

import com.restaurant.restaurant_app.models.RestaurantRequest;
import com.restaurant.restaurant_app.service.RestaurantService;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Override
    public boolean addRestaurant(RestaurantRequest restaurantRequest) {
        return false;
    }
}
