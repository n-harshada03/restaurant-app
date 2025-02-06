package com.restaurant.restaurant_app.controller;

import com.restaurant.restaurant_app.models.RestaurantRequest;
import com.restaurant.restaurant_app.models.RestaurantResponse;
import com.restaurant.restaurant_app.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restro")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) { //dependency injected
        this.restaurantService = restaurantService;
    }

    @GetMapping("/new")
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity<>("Hello from API", HttpStatus.OK);
    }

    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurants(){
        return new ResponseEntity<>(restaurantService.getRestaurants(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> registerRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        restaurantService.addRestaurant(restaurantRequest);
        return new ResponseEntity<>("Restro name is " + restaurantRequest.getRestroName() + " and restro type is " + restaurantRequest.getRestroType(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<String> deleteRestaurantByName(@PathVariable("name") String restroName){
        restaurantService.deleteRestaurant(restroName);
        return new ResponseEntity<>("Restaurant " + restroName + " is deleted. ",HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRestaurant(@PathVariable("id") int restroId, @RequestBody RestaurantRequest restaurantRequest){
        boolean isUpdated =  restaurantService.updateRestaurant(restroId,restaurantRequest);
        if(isUpdated){
            return new ResponseEntity<>("Restaurant details updated. ",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Restaurant not found. ",HttpStatus.NOT_FOUND);
        }
    }

}
