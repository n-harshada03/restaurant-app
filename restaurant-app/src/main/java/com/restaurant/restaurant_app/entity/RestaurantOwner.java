package com.restaurant.restaurant_app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="restaurant_owner")
public class RestaurantOwner {

    @Id
    @SequenceGenerator(name = "seq_restaurant_owner",sequenceName = "seq_restaurant_owner",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_restaurant_owner")
    @Column(name = "owner_id")
    private int ownerId;

    @Column(name="first_name",length=100, nullable = false)
    private String firstName;

    @Column(name="middle_name",length=100)
    private String middleName;

    @Column(name="last_name",length=100, nullable = false)
    private String lastName;

    @Column(name="country_code",length=10, nullable = false)
    private String countryCode;

    @Column(name="mobile",length=10, nullable = false,unique = true)
    private String mobile;

    @Column(name="email",length=100, nullable = false,unique = true)
    private String email;


    @Enumerated(EnumType.STRING)
    @Column(name="government_id_type", nullable = false)
    private GovernmentIdType governmentIdType;

    @Column(name="government_id",length=20, nullable = false,unique = true)
    private String government_id;

    @Column(name="password",length = 100, nullable = false)
    private String password;

    public enum GovernmentIdType{
        Pancard, Aadharcard
    }

}
