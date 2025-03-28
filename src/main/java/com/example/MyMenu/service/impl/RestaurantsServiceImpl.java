package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.images.RestaurantsImage;
import com.example.MyMenu.entity.restauants.Restaurants;
import com.example.MyMenu.entity.restauants.RestaurantsDTO;
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

    @Autowired
    public RestaurantsServiceImpl(RestaurantsRepository restaurantsRepository,RestaurantsImageRepository restaurantsImageRepository) {
        this.restaurantsRepository = restaurantsRepository;
        this.restaurantsImageRepository = restaurantsImageRepository;
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
        Restaurants restaurants = new Restaurants();
        restaurants.setDescription(restaurantsDTO.getDescription());
        restaurants.setRestaurantName(restaurantsDTO.getRestaurantName());
        restaurants.setWorkHours(restaurantsDTO.getWorkHours());

        List<RestaurantsImage> imageList = restaurantsImageRepository.findAllById(restaurantsDTO.getImageIds());
        restaurants.setImageList(imageList);

        Restaurants savedRestaurant = restaurantsRepository.save(restaurants);
        return savedRestaurant;
    }

//    public Optional<Restaurants> getByName(String restaurantName){
//        Optional<Restaurants> restaurant = restaurantsRepository.findByName(restaurantName);
//
//        if(restaurant.isEmpty()){
//            throw new RuntimeException("Error");
//        }
//        return restaurant;
//    }
}
