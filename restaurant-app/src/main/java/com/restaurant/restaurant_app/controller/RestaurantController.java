package com.restaurant.restaurant_app.controller;

import com.restaurant.restaurant_app.models.RestaurantRequest;
import com.restaurant.restaurant_app.models.RestaurantResponse;
import com.restaurant.restaurant_app.service.RestaurantService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(@Qualifier("restaurantServiceImpl") RestaurantService restaurantService) { //dependency injected
        this.restaurantService = restaurantService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        boolean isCreated = restaurantService.addRestaurant(restaurantRequest);
        if (isCreated) {
            return new ResponseEntity<>("Restaurant registered successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to register restaurant.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurants(){
        return new ResponseEntity<>(restaurantService.getRestaurants(),HttpStatus.OK);
    }


    @PutMapping("/update/{name}")
    public ResponseEntity<String> updateRestaurant(@PathVariable("name") String restaurantName, @RequestBody RestaurantRequest restaurantRequest){
        boolean isUpdated =  restaurantService.updateRestaurant(restaurantName,restaurantRequest);
        if(isUpdated){
            return new ResponseEntity<>("Restaurant details updated. ",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Restaurant not found. ",HttpStatus.NOT_FOUND);
        }
    }

}
