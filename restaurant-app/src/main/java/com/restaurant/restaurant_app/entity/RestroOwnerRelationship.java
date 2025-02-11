package com.restaurant.restaurant_app.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="restro_owner_relationship")
public class RestroOwnerRelationship {

    @Id
    @SequenceGenerator(name = "seq_restro_owner_relationship",sequenceName = "seq_restro_owner_relationship",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_restro_owner_relationship")
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="restro_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="owner_id", nullable = false)
    private RestaurantOwner owner;
}
