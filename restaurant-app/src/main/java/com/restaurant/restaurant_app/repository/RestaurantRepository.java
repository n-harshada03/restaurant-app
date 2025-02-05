package com.restaurant.restaurant_app.repository;

import com.restaurant.restaurant_app.entity.Restaurant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    boolean existsByRestroName(String restroName);

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.restroName = :restroName")
    void deleteByRestroName(@Param("restroName") String restroName);

}
