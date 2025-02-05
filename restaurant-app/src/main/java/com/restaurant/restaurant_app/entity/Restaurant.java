package com.restaurant.restaurant_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restro_id")
    private int restroId;

    @Column(name="restro_name", length = 100, nullable = false)
    private String restroName;

//    @Enumerated(EnumType.STRING)
    @Column(name="restro_type", length=50,nullable = false)
//    private RestroType restroType;
    private String restroType;

    @Column(name="speciality", length = 200)
    private String speciality;

    @Column(name="service_type", length = 30, nullable = false)
    private String serviceType;

    @Column(name="opening_hour", length = 20, nullable = false)
    private String openingHour;

    @Column(name="closing_hour", length = 20, nullable = false)
    private String closingHour;

//    @ManyToOne
//    @JoinColumn(name="address_id",nullable = false)
//    private RestaurantAddress baseAddress;


//    public enum RestroType{
//        Veg, Nonveg;
//    }

}

