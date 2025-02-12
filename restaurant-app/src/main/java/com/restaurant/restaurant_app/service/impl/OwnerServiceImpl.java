package com.restaurant.restaurant_app.service.impl;

import com.restaurant.restaurant_app.entity.Restaurant;
import com.restaurant.restaurant_app.entity.RestaurantOwner;
import com.restaurant.restaurant_app.entity.RestroOwnerRelationship;
import com.restaurant.restaurant_app.models.OwnerRequest;
import com.restaurant.restaurant_app.models.OwnerResponse;
import com.restaurant.restaurant_app.models.RestaurantResponse;
import com.restaurant.restaurant_app.repository.RestaurantOwnerRepository;
import com.restaurant.restaurant_app.repository.RestaurantRepository;
import com.restaurant.restaurant_app.repository.RestroOwnerRelationshipRepository;
import com.restaurant.restaurant_app.service.OwnerService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final RestaurantOwnerRepository restaurantOwnerRepository;
    private final RestroOwnerRelationshipRepository restroOwnerRelationshipRepository;

    public OwnerServiceImpl(RestaurantOwnerRepository restaurantOwnerRepository, RestroOwnerRelationshipRepository restroOwnerRelationshipRepository) {
        this.restaurantOwnerRepository = restaurantOwnerRepository;
        this.restroOwnerRelationshipRepository = restroOwnerRelationshipRepository;
    }

    @Override
    public boolean addOwner(OwnerRequest ownerRequest) {

        RestaurantOwner restaurantOwner=mapDTOtoOwnerEntity(ownerRequest);
        RestaurantOwner savedOwner=restaurantOwnerRepository.save(restaurantOwner);

        return savedOwner!=null;

    }

    private RestaurantOwner mapDTOtoOwnerEntity(OwnerRequest ownerRequest) {
        return new RestaurantOwner().builder()
                .firstName(ownerRequest.getOwnerFirstName())
                .middleName(ownerRequest.getOwnerMiddleName())
                .lastName(ownerRequest.getOwnerLastName())
                .countryCode(ownerRequest.getCountryCode())
                .mobile(ownerRequest.getOwnerMobileNumber())
                .email(ownerRequest.getOwnerEmail())
                .governmentIdType(ownerRequest.getGovernmentIdType())
                .government_id(ownerRequest.getGovernmentId())
                .password(ownerRequest.getPassword())
                .build();

    }


    @Override
    public List<RestaurantResponse> getAllRestaurantsByOwnerEmail(String email) {
        RestaurantOwner owner = restaurantOwnerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        List<RestroOwnerRelationship> relationship= restroOwnerRelationshipRepository.findByOwnerId(owner.getOwnerId());

        return relationship.stream()
                .map(rel -> mapToResponse(rel.getRestaurant()))
                .toList();
    }

    //write query for this
    //transform each Restaurant object into a RestaurantResponse
    private RestaurantResponse mapToResponse(Restaurant restaurant) {
        return RestaurantResponse.builder()
                .restroName(restaurant.getRestroName())
                .restroType(restaurant.getRestroType().toString())
                .serviceType(restaurant.getServiceType())
                .speciality(restaurant.getSpeciality())
                .openingHour(restaurant.getOpeningHour())
                .closingHour(restaurant.getClosingHour())
                .build();
    }

    @Override
    public List<OwnerResponse> getAllOwners() {
        List<RestaurantOwner> owner=restaurantOwnerRepository.findAll();
        List<OwnerResponse> listOfOwners=mapEntityToResponse(owner);
        return listOfOwners;
    }

    private List<OwnerResponse> mapEntityToResponse(List<RestaurantOwner> owner) {

        return owner.stream()
                .map(newOwner -> OwnerResponse.builder()
                        .ownerFirstName(newOwner.getFirstName())
                        .ownerLastName(newOwner.getLastName())
                        .ownerMobileNumber(newOwner.getMobile())
                        .ownerEmail(newOwner.getEmail())
                        .build())
                .toList();
    }

}
