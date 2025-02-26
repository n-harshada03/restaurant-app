package com.restaurant.restaurant_app.service;

import com.restaurant.restaurant_app.models.OwnerRequest;
import com.restaurant.restaurant_app.models.OwnerResponse;
import com.restaurant.restaurant_app.models.RestaurantRequest;
import com.restaurant.restaurant_app.models.RestaurantResponse;

import java.util.List;

public interface OwnerService {

    public boolean addOwner(OwnerRequest ownerRequest);

    public List<RestaurantResponse> getAllRestaurantsByOwnerEmail(String email);

    public List<OwnerResponse> getAllOwners();
}