package com.restaurant.restaurant_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="restaurant")
@Getter
@Setter
public class Restaurant {

    @Id
    @Column(name = "restro_id")
    private int restroId;

    @Column(name="restro_name", length = 100, nullable = false)
    private String restroName;

    @Enumerated(EnumType.STRING)
    @Column(name="restro_type", nullable = false)
    private RestroType restroType;

    @Column(name="speciality", length = 200)
    private String speciality;

    @Column(name="service_type", length = 30, nullable = false)
    private String serviceType;

    @Column(name="opening_hour", length = 20, nullable = false)
    private String openingHour;

    @Column(name="closing_hour", length = 20, nullable = false)
    private String closingHour;

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantAddress> baseAddress;

    public enum RestroType{
        Veg, Nonveg;
    }

}

