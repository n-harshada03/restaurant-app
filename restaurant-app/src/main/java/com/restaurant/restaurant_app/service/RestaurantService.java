package com.restaurant.restaurant_app.service;

import com.restaurant.restaurant_app.entity.Restaurant;
import com.restaurant.restaurant_app.models.RestaurantRequest;
import com.restaurant.restaurant_app.models.RestaurantResponse;

import java.util.List;

public interface RestaurantService {

    public boolean addRestaurant(RestaurantRequest restaurantRequest);

    public List<RestaurantResponse> getRestaurants();

    public boolean deleteRestaurant(String restroName);

    public boolean updateRestaurant(int restroId,RestaurantRequest restaurantRequest);

}
