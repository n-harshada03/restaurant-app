package com.restaurant.restaurant_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="restaurant_address")
@Getter
@Setter
public class RestaurantAddress {

    @Id
    @Column(name = "address_id")
    private int addressId;

    @ManyToOne
    @JoinColumn(name="restro_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "address_line1",length=200, nullable = false)
    private String addressLine1;

    @Column(name="address_line2",length = 200)
    private String addressLine2;

    @Column(name="city",length = 50, nullable = false)
    private String city;

    @Column(name="state",length = 50, nullable = false)
    private String state;

    @Column(name="country",length = 50, nullable = false)
    private String country;

    @Column(name="pincode",length = 10, nullable = false)
    private String pincode;


}
