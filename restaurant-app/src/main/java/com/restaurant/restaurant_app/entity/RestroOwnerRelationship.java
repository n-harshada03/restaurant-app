package com.restaurant.restaurant_app.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="restro_owner_relationship")
@Getter
@Setter
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
