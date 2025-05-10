package com.restaurant.restaurant_app.repository;

import com.restaurant.restaurant_app.entity.RestaurantAddress;
import com.restaurant.restaurant_app.entity.RestaurantContact;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantContactRepository extends JpaRepository<RestaurantContact,Integer> {

    @Query("SELECT rc FROM RestaurantContact rc WHERE rc.address = :address")
    Optional<RestaurantContact> findByAddress(@Param("address") RestaurantAddress address);

}
