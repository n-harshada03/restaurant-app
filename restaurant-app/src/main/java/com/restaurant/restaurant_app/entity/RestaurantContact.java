package com.restaurant.restaurant_app.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="restaurant_contact")
public class RestaurantContact {

    @Id
    @Column(name = "contact_id")
    private int contactId;

    @ManyToOne
    @JoinColumn(name="address_id", nullable=false)
    private RestaurantAddress address;

    @Column(name="mobile",length=20,nullable = false)
    private String mobile;

    @Column(name="email" ,length=100, nullable = false)
    private String email;



}
