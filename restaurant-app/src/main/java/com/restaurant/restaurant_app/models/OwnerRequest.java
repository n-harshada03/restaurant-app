package com.restaurant.restaurant_app.models;

import com.restaurant.restaurant_app.entity.RestaurantOwner;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OwnerRequest {

    private String ownerFirstName;
    private String ownerMiddleName;
    private String ownerLastName;
    private String countryCode;
    private String ownerMobileNumber;
    private String ownerEmail;
    private RestaurantOwner.GovernmentIdType governmentIdType;
    private String governmentId;
    private String password;

}
