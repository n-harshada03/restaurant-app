package com.restaurant.restaurant_app.repository;

import com.restaurant.restaurant_app.entity.RestaurantOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwner,Integer> {
}
