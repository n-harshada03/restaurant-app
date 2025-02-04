package com.restaurant.restaurant_app.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="restro_owner_relationship")
public class RestroOwnerRelationship {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="restro_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name="owner_id", nullable = false)
    private RestaurantOwner owner;
}
