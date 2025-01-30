package com.restaurant.restaurant_app.repository;

import com.restaurant.restaurant_app.entity.RestaurantLegalDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantLegalDocumentsRepository extends JpaRepository<RestaurantLegalDocuments,Integer> {
}
