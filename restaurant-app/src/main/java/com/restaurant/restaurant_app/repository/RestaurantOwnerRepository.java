package com.restaurant.restaurant_app.repository;

import com.restaurant.restaurant_app.entity.RestaurantOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwner,Integer> {

    Optional<RestaurantOwner> findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);


}
