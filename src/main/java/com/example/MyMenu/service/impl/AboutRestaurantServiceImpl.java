package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.about.AboutRestaurants;
import com.example.MyMenu.enums.Facilities;
import com.example.MyMenu.enums.SocialNetworks;
import com.example.MyMenu.repository.AboutRestaurantRepository;
import com.example.MyMenu.service.AboutRestaurantsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AboutRestaurantServiceImpl implements AboutRestaurantsService {

    private final AboutRestaurantRepository aboutRestaurantRepository;

    @Autowired
    public AboutRestaurantServiceImpl(AboutRestaurantRepository aboutRestaurantRepository) {
        this.aboutRestaurantRepository = aboutRestaurantRepository;
    }

    @Override
    public void deleteById(Long id) {
        if(aboutRestaurantRepository.existsById(id)){
            aboutRestaurantRepository.deleteById(id);
        }
    }

    @Override
    public AboutRestaurants save(AboutRestaurants entity) {
        return aboutRestaurantRepository.save(entity);
    }

    @Override
    public Optional<AboutRestaurants> getById(Long id) {
        Optional<AboutRestaurants> restaurants = aboutRestaurantRepository.findById(id);

        if(restaurants.isEmpty()){
            throw new RuntimeException("Error");
        }
        return restaurants;
    }

    @Override
    public List<AboutRestaurants> getAll() {
        return aboutRestaurantRepository.findAll();
    }

    public List<AboutRestaurants> getByFacilities(Facilities facilities){
        List<AboutRestaurants> restaurantsList =
                aboutRestaurantRepository.findByFacilities(facilities);

        if(restaurantsList.isEmpty()){
            throw new RuntimeException("Error");
        }

        return restaurantsList;
    }

    public List<AboutRestaurants> getBySocialNetworks(SocialNetworks socialNetworks){
        List<AboutRestaurants> restaurantsList =
                aboutRestaurantRepository.findBySocialNetworks(socialNetworks);

        if(restaurantsList.isEmpty()){
            throw new RuntimeException("Error");
        }

        return restaurantsList;
    }
}
