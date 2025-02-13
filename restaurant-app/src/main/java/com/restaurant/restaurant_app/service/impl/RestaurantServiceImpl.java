package com.restaurant.restaurant_app.service.impl;

import com.restaurant.restaurant_app.entity.*;
import com.restaurant.restaurant_app.models.RestaurantRequest;
import com.restaurant.restaurant_app.models.RestaurantResponse;
import com.restaurant.restaurant_app.repository.*;
import com.restaurant.restaurant_app.service.RestaurantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantAddressRepository restaurantAddressRepository;
    private final RestaurantContactRepository restaurantContactRepository;
    private final RestaurantLegalDocumentsRepository restaurantLegalDocumentsRepository;
    private final RestaurantOwnerRepository restaurantOwnerRepository;
    private final RestroOwnerRelationshipRepository restroOwnerRelationshipRepository;


    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, RestaurantAddressRepository restaurantAddressRepository, RestaurantContactRepository restaurantContactRepository, RestaurantLegalDocumentsRepository restaurantLegalDocumentsRepository, RestaurantOwnerRepository restaurantOwnerRepository, RestroOwnerRelationshipRepository restroOwnerRelationshipRepository) { //dependency injected
        this.restaurantRepository = restaurantRepository;
        this.restaurantAddressRepository = restaurantAddressRepository;
        this.restaurantContactRepository = restaurantContactRepository;
        this.restaurantLegalDocumentsRepository = restaurantLegalDocumentsRepository;
        this.restaurantOwnerRepository = restaurantOwnerRepository;
        this.restroOwnerRelationshipRepository = restroOwnerRelationshipRepository;
    }

    @Override
    public boolean addRestaurant(RestaurantRequest restaurantRequest) {
        //Converts the RestaurantRequest DTO into a Restaurant entity

        Optional<RestaurantOwner> existingOwner=restaurantOwnerRepository.findByFirstNameAndLastNameAndEmail(restaurantRequest.getOwnerFirstName(),restaurantRequest.getOwnerLastName(),restaurantRequest.getEmail());
        if(existingOwner.isEmpty()){
            throw new RuntimeException("Owner with given info is not registered.");
        }

        Restaurant restaurant=mapDTOtoRestaurantEntity(restaurantRequest,null);
        Restaurant savedRestaurant= restaurantRepository.save(restaurant); //save to database

        RestaurantAddress restaurantAddress=mapDTOtoAddressEntity(restaurantRequest);
        restaurantAddress.setRestaurant(savedRestaurant);
        RestaurantAddress savedAddress= restaurantAddressRepository.save(restaurantAddress);

        RestaurantContact restaurantContact=mapDTOtoContactEntity(restaurantRequest,savedAddress);
        RestaurantContact savedContact=restaurantContactRepository.save(restaurantContact);

        RestaurantLegalDocuments restaurantLegalDocuments=mapDTOtoDocstEntity(restaurantRequest,savedAddress);
        RestaurantLegalDocuments savedDocument=restaurantLegalDocumentsRepository.save(restaurantLegalDocuments);

        savedRestaurant.setBaseAddress(savedAddress);
        restaurantRepository.save(savedRestaurant);

        RestroOwnerRelationship relationship=new RestroOwnerRelationship();
        relationship.setOwner(existingOwner.get());
        relationship.setRestaurant(savedRestaurant);
        restroOwnerRelationshipRepository.save(relationship);

        return savedRestaurant != null;
    }

    private Restaurant mapDTOtoRestaurantEntity(RestaurantRequest restaurantRequest,RestaurantAddress savedAddress) {
        return Restaurant.builder()
                .restroName(restaurantRequest.getRestaurantName())
                .restroType(restaurantRequest.getRestroType())
                .serviceType(restaurantRequest.getServiceType())
                .speciality(restaurantRequest.getSpeciality())
                .openingHour(restaurantRequest.getOpeningHour())
                .closingHour(restaurantRequest.getClosingHour())
                .logo(restaurantRequest.getLogo())
                .baseAddress(savedAddress)
                .build();

    }

    private RestaurantAddress mapDTOtoAddressEntity(RestaurantRequest restaurantRequest) {
        return RestaurantAddress.builder()
                .addressLine1(restaurantRequest.getAddressLine1())
                .addressLine2(restaurantRequest.getAddressLine2())
                .city(restaurantRequest.getCity())
                .state(restaurantRequest.getState())
                .country(restaurantRequest.getCountry())
                .build();
    }

    private RestaurantContact mapDTOtoContactEntity(RestaurantRequest restaurantRequest,RestaurantAddress savedAddress) {
        return RestaurantContact.builder()
                .address(savedAddress)
                .mobile(restaurantRequest.getMobileNo())
                .build();

    }

    private RestaurantLegalDocuments mapDTOtoDocstEntity(RestaurantRequest restaurantRequest,RestaurantAddress savedAddress) {
        return RestaurantLegalDocuments.builder()
                .address(savedAddress)
                .foodLicense(restaurantRequest.getFoodLicense())
                .build();

    }


    @Override
    public List<RestaurantResponse> getRestaurants() {
        List<Restaurant> restaurant = restaurantRepository.findAll();//retrieve all records
        List<RestaurantResponse> listOfRestaurants = mapEntityToDTO(restaurant);//converts DTO into obj
        return listOfRestaurants;
    }


    //    Transforms each Restaurant object into a RestaurantResponse.
    private List<RestaurantResponse> mapEntityToDTO(List<Restaurant> restaurant) {
        return restaurant.stream()
                .map(restro -> RestaurantResponse.builder()
                        .restroName(restro.getRestroName())
                        .restroType(String.valueOf(restro.getRestroType()))
                        .serviceType(restro.getServiceType())
                        .speciality(restro.getSpeciality())
                        .openingHour(restro.getOpeningHour())
                        .closingHour(restro.getClosingHour())
                        .build())
                .toList();
    }


    @Override
    @Transactional
    public boolean updateRestaurant(String restaurantName, RestaurantRequest restaurantRequest) {
        Optional<Restaurant> existingRestaurant = restaurantRepository.findByRestroName(restaurantName);

        if (existingRestaurant.isEmpty()) return false;

        Restaurant restaurant = existingRestaurant.get();
        //two restro with same name
        //objectUtils.isEmpty()-It checks for null, empty strings (""), empty collections, and empty arrays.
        // Updating restaurant details
        restaurant.setRestroName(!ObjectUtils.isEmpty(restaurantRequest.getRestaurantName()) ? restaurantRequest.getRestaurantName() : restaurant.getRestroName());
        restaurant.setRestroType(!ObjectUtils.isEmpty(restaurantRequest.getRestroType()) ? restaurantRequest.getRestroType() : restaurant.getRestroType());
        restaurant.setServiceType(!ObjectUtils.isEmpty(restaurantRequest.getServiceType()) ? restaurantRequest.getServiceType() : restaurant.getServiceType());
        restaurant.setSpeciality(!ObjectUtils.isEmpty(restaurantRequest.getSpeciality()) ? restaurantRequest.getSpeciality() : restaurant.getSpeciality());
        restaurant.setOpeningHour(!ObjectUtils.isEmpty(restaurantRequest.getOpeningHour()) ? restaurantRequest.getOpeningHour() : restaurant.getOpeningHour());
        restaurant.setClosingHour(!ObjectUtils.isEmpty(restaurantRequest.getClosingHour()) ? restaurantRequest.getClosingHour() : restaurant.getClosingHour());
        restaurant.setLogo(!ObjectUtils.isEmpty(restaurantRequest.getLogo()) ? restaurantRequest.getLogo() : restaurant.getLogo());


        RestaurantAddress address = restaurant.getBaseAddress()!= null ? restaurant.getBaseAddress() : new RestaurantAddress();

        address.setAddressLine1(!ObjectUtils.isEmpty(restaurantRequest.getAddressLine1()) ? restaurantRequest.getAddressLine1() : address.getAddressLine1());
        address.setAddressLine2(!ObjectUtils.isEmpty(restaurantRequest.getAddressLine2()) ? restaurantRequest.getAddressLine2() : address.getAddressLine2());
        address.setCity(!ObjectUtils.isEmpty(restaurantRequest.getCity()) ? restaurantRequest.getCity() : address.getCity());
        address.setState(!ObjectUtils.isEmpty(restaurantRequest.getState()) ? restaurantRequest.getState() : address.getState());
        address.setCountry(!ObjectUtils.isEmpty(restaurantRequest.getCountry()) ? restaurantRequest.getCountry() : address.getCountry());

        restaurant.setBaseAddress(address);

        Optional<RestaurantContact> contactOpt = restaurantContactRepository.findByAddress(address);
            RestaurantContact contact = contactOpt.orElseGet(() -> {
                RestaurantContact newContact = new RestaurantContact();
                newContact.setAddress(address);
                return newContact;
            });

        contact.setMobile(restaurantRequest.getMobileNo() != null ? restaurantRequest.getMobileNo() : contact.getMobile());

            restaurantContactRepository.save(contact);

            Optional<RestaurantLegalDocuments> legalDocsOpt = restaurantLegalDocumentsRepository.findByAddress(address);
            RestaurantLegalDocuments legalDocs = legalDocsOpt.orElseGet(() -> {
                RestaurantLegalDocuments newDocs = new RestaurantLegalDocuments();
                newDocs.setAddress(address);
                return newDocs;
            });

            legalDocs.setFoodLicense(restaurantRequest.getFoodLicense() != null ? restaurantRequest.getFoodLicense():legalDocs.getFoodLicense());
            restaurantLegalDocumentsRepository.save(legalDocs);

            restaurantRepository.save(restaurant);

        return true;
    }


}
