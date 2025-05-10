package com.restaurant.restaurant_app.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="restaurant_legal_documents")
public class RestaurantLegalDocuments {


    @Id
    @SequenceGenerator(name = "seq_restaurant_legal_documents",sequenceName = "seq_restaurant_legal_documents",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_restaurant_legal_documents")
    @Column(name="legal_id")
    private int legalId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private RestaurantAddress address;


    @Column(name="food_license" ,length = 30, unique = true)
    private String foodLicense;
}
