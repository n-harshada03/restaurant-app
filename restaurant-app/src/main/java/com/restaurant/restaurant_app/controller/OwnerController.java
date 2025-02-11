package com.restaurant.restaurant_app.controller;

import com.restaurant.restaurant_app.models.OwnerRequest;
import com.restaurant.restaurant_app.models.RestaurantResponse;
import com.restaurant.restaurant_app.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerOwner(@RequestBody OwnerRequest ownerRequest){
        boolean success = ownerService.addOwner(ownerRequest);
        if(success){
            return new ResponseEntity<>("Owner registered successfully!", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getrestaurants")
    public ResponseEntity<List<RestaurantResponse>> getRestaurantsByOwnerEmail(@RequestParam String email) {
        List<RestaurantResponse> restaurants = ownerService.getAllRestaurantsByOwnerEmail(email);
        if (restaurants.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restaurants);
        }
        return ResponseEntity.ok(restaurants);
    }
}
