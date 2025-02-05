package com.restaurant.restaurant_app.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="restaurant_contact")
public class RestaurantContact {

    @Id
    @SequenceGenerator(name = "seq_restaurant_contact",sequenceName = "seq_restaurant_contact",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_restaurant_contact")
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
