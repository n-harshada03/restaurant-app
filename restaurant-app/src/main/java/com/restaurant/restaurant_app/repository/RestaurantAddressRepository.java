package com.restaurant.restaurant_app.repository;

import com.restaurant.restaurant_app.entity.RestaurantAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantAddressRepository extends JpaRepository<RestaurantAddress,Integer> {

}
