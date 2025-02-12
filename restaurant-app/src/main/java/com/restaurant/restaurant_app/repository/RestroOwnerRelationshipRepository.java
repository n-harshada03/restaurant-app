package com.restaurant.restaurant_app.repository;

import com.restaurant.restaurant_app.entity.Restaurant;
import com.restaurant.restaurant_app.entity.RestroOwnerRelationship;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestroOwnerRelationshipRepository extends JpaRepository<RestroOwnerRelationship,Integer> {

    @Query("SELECT r FROM RestroOwnerRelationship r WHERE r.owner.ownerId = :ownerId")
    List<RestroOwnerRelationship> findByOwnerId(@Param("ownerId") int ownerId);


//    @Query("SELECT r FROM RestroOwnerRelationship r WHERE r.owner.ownerId = :ownerId AND r.restaurant.restroName = :restaurantName")
//    Optional<RestroOwnerRelationship> findByOwnerAndRestroName(@Param("ownerId") int ownerId, @Param("restaurantName") String restaurantName);
}
