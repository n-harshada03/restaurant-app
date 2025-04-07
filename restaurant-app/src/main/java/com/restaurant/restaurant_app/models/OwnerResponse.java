package com.restaurant.restaurant_app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnerResponse {
    private String username;
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerMobileNumber;
    private String ownerEmail;

}
