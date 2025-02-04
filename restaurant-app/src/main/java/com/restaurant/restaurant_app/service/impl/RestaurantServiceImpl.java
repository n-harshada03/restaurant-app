package com.restaurant.restaurant_app.service.impl;

import com.restaurant.restaurant_app.entity.Restaurant;
import com.restaurant.restaurant_app.models.RestaurantRequest;
import com.restaurant.restaurant_app.repository.RestaurantRepository;
import com.restaurant.restaurant_app.service.RestaurantService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) { //dependency injected
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public boolean addRestaurant(RestaurantRequest restaurantRequest) {
        //Converts the RestaurantRequest DTO into a Restaurant entity
        Restaurant restaurant=mapDTOtoEntity(restaurantRequest);
        Restaurant persistedDetails= restaurantRepository.save(restaurant); //save to database

        if (ObjectUtils.isEmpty(persistedDetails)) {
            return false;
        }

        return true;
    }

    private Restaurant mapDTOtoEntity(RestaurantRequest restaurantRequest) {
        return Restaurant.builder()
                .restroName(restaurantRequest.getRestroName())
                .restroType(restaurantRequest.getRestroType())
                .serviceType(restaurantRequest.getServiceType())
                .speciality(restaurantRequest.getSpeciality())
                .openingHour(restaurantRequest.getOpening_hour())
                .closingHour(restaurantRequest.getClosing_hour())
                .build();
    }
}
