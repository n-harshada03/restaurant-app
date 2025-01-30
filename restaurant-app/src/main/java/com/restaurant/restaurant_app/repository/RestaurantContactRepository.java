package com.restaurant.restaurant_app.repository;

import com.restaurant.restaurant_app.entity.RestaurantContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantContactRepository extends JpaRepository<RestaurantContact,Integer> {
}
