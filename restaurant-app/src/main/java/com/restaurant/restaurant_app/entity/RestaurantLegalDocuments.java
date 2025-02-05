package com.restaurant.restaurant_app.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="restaurant_legal_documents")
public class RestaurantLegalDocuments {


    @Id
    @SequenceGenerator(name = "seq_restaurant_legal_documents",sequenceName = "seq_restaurant_legal_documents",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_restaurant_legal_documents")
    @Column(name="legal_id")
    private int legalId;

    @ManyToOne
    @JoinColumn(name="address_id",nullable = false)
    private RestaurantAddress address;


    @Column(name="food_license" ,length = 30, unique = true)
    private String foodLicense;
}
