package com.restaurant.restaurant_app.repository;

import com.restaurant.restaurant_app.entity.Restaurant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {

    Optional<Restaurant> findByRestroName(String restaurantName);

    @Query("SELECT r FROM Restaurant r WHERE r.restroName = :restroName AND r.baseAddress.addressLine1 = :address AND r.baseAddress.city = :city")
    Optional<Restaurant> findByRestroNameAndBaseAddress(@Param("restroName") String restroName,@Param("address") String address, @Param("city") String city);

}
