package com.restaurant.restaurant_app.service;

import com.restaurant.restaurant_app.models.RestaurantRequest;
import com.restaurant.restaurant_app.models.RestaurantResponse;

import java.util.List;

public interface RestaurantService {

    public boolean addRestaurant(RestaurantRequest restaurantRequest);

    public List<RestaurantResponse> getRestaurants();

//    public boolean deleteRestaurant(Integer restroId);

//    public boolean updateRestaurant(String restaurantName,RestaurantRequest restaurantRequest);
}
