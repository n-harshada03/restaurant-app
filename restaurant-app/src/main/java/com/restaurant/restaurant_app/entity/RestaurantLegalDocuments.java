package com.restaurant.restaurant_app.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="restaurant_legal_documents")
@Getter
@Setter
public class RestaurantLegalDocuments {


    @Id
    @Column(name="legal_id")
    private int legalId;

    @ManyToOne
    @JoinColumn(name="address_id",nullable = false)
    private RestaurantAddress address;


    @Column(name="food_license" ,length = 30, unique = true)
    private String foodLicense;
}
