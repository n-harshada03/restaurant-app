package com.restaurant.restaurant_app.repository;

import com.restaurant.restaurant_app.entity.RestaurantAddress;
import com.restaurant.restaurant_app.entity.RestaurantLegalDocuments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantLegalDocumentsRepository extends JpaRepository<RestaurantLegalDocuments,Integer> {

     @Query("SELECT rld FROM RestaurantLegalDocuments rld WHERE rld.address = :address")
     Optional<RestaurantLegalDocuments> findByAddress(@Param("address") RestaurantAddress address);

}
