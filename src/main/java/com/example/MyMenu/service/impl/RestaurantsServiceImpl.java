package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.Address;
import com.example.MyMenu.entity.about.AboutRestaurants;
import com.example.MyMenu.entity.images.RestaurantsImage;
import com.example.MyMenu.entity.Restaurants;
import com.example.MyMenu.dtos.RestaurantsDTO;
import com.example.MyMenu.repository.AboutRestaurantRepository;
import com.example.MyMenu.repository.AddressRepository;
import com.example.MyMenu.repository.RestaurantsImageRepository;
import com.example.MyMenu.repository.RestaurantsRepository;
import com.example.MyMenu.service.RestaurantsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestaurantsServiceImpl implements RestaurantsService {

    private final RestaurantsRepository restaurantsRepository;
    private final RestaurantsImageRepository restaurantsImageRepository;
    private final AddressRepository addressRepository;
    private final AboutRestaurantRepository aboutRestaurantRepository;

    @Autowired
    public RestaurantsServiceImpl(RestaurantsRepository restaurantsRepository,
                                  RestaurantsImageRepository restaurantsImageRepository,
                                  AddressRepository addressRepository,
                                  AboutRestaurantRepository aboutRestaurantRepository) {
        this.restaurantsRepository = restaurantsRepository;
        this.restaurantsImageRepository = restaurantsImageRepository;
        this.addressRepository=addressRepository;
        this.aboutRestaurantRepository=aboutRestaurantRepository;
    }

    @Override
    public void deleteById(Long id) {
        if(restaurantsRepository.existsById(id)){
            restaurantsRepository.deleteById(id);
        }
    }

    @Override
    public Restaurants save(Restaurants entity) {
        return restaurantsRepository.save(entity);
    }

    @Override
    public Optional<Restaurants> getById(Long id) {

        Optional<Restaurants> restaurants = restaurantsRepository.findById(id);

        if(restaurants.isEmpty()){
            throw new RuntimeException("Error");
        }

        return restaurants;
    }

    @Override
    public List<Restaurants> getAll() {
        return restaurantsRepository.findAll();
    }

    @Override
    public Restaurants create(RestaurantsDTO restaurantsDTO) {
        Restaurants restaurants = convertToEntity(restaurantsDTO);

        return restaurantsRepository.save(restaurants);
    }

    @Override
    public Optional<Restaurants> updateById(Long id,RestaurantsDTO restaurantsDTO) {

//        return restaurantsRepository.findById(id).map(existingRestaurant ->{
//            Restaurants updatedRestaurant = convertToEntity(restaurantsDTO);
//            updatedRestaurant.setId(existingRestaurant.getId());
//
//            return restaurantsRepository.save(updatedRestaurant);
//        });
        if(restaurantsRepository.existsById(id)){
            Optional<Restaurants> existingRestaurant = Optional.ofNullable(restaurantsRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id)));
            Restaurants updatedRestaurant = convertToEntity(restaurantsDTO);

            updatedRestaurant.setId(existingRestaurant.get().getId());

            return Optional.of(restaurantsRepository.save(updatedRestaurant));
        }
        else {
            throw new IllegalArgumentException("Ids must not be null or empty");
        }



    }

    public List<Restaurants> getByUserName(String restaurantName){
        List<Restaurants> restaurant = restaurantsRepository.findByRestaurantName(restaurantName);

        if(restaurant.isEmpty()){
            throw new RuntimeException("Error");
        }
        return restaurant;
    }

    public Restaurants convertToEntity(RestaurantsDTO restaurantsDTO){
        Restaurants restaurants = new Restaurants();
        List<RestaurantsImage> imageList = restaurantsImageRepository.findAllById(restaurantsDTO.getImageIds());
        List<Address> addressList = addressRepository.findAllById(restaurantsDTO.getAddressIds());
        List<AboutRestaurants> about = aboutRestaurantRepository.findAllById(restaurantsDTO.getAbout());
        restaurants.setRestaurantName(restaurantsDTO.getRestaurantName());
        restaurants.setDescription(restaurantsDTO.getDescription());
        restaurants.setImageList(imageList);
        restaurants.setAddressList(addressList);
        restaurants.setWorkHours(restaurantsDTO.getWorkHours());
        restaurants.setId(restaurants.getId());

        return restaurants;



    }
}
