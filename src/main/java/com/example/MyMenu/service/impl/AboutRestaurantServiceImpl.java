package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.about.AboutRestaurants;
import com.example.MyMenu.enums.Facilities;
import com.example.MyMenu.enums.SocialNetworks;
import com.example.MyMenu.exceptions.EmptyListException;
import com.example.MyMenu.exceptions.NoAboutByFacilitiesException;
import com.example.MyMenu.exceptions.NoAboutBySocialNetworkExc;
import com.example.MyMenu.exceptions.NoEntityByIdException;
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
    public void deleteById(Long id) throws NoEntityByIdException {
        if(aboutRestaurantRepository.existsById(id)){
            aboutRestaurantRepository.deleteById(id);
        }else {
            throw new NoEntityByIdException(id);
        }
    }

    @Override
    public AboutRestaurants save(AboutRestaurants entity) {
        return aboutRestaurantRepository.save(entity);
    }

    @Override
    public Optional<AboutRestaurants> getById(Long id) throws NoEntityByIdException {
        Optional<AboutRestaurants> restaurants = aboutRestaurantRepository.findById(id);

        if(restaurants.isEmpty()){
            throw new NoEntityByIdException(id);
        }
        return restaurants;
    }

    @Override
    public List<AboutRestaurants> getAll()  throws EmptyListException {

        List<AboutRestaurants> list =aboutRestaurantRepository.findAll();
        if(list.isEmpty()){
            throw new EmptyListException();
        }
        return list;
    }

    public List<AboutRestaurants> getByFacilities(Facilities facilities) throws NoAboutByFacilitiesException{
        List<AboutRestaurants> restaurantsList =
                aboutRestaurantRepository.findByFacilities(facilities);

        if(restaurantsList.isEmpty()){
            throw new NoAboutByFacilitiesException(facilities);
        }

        return restaurantsList;
    }

    public List<AboutRestaurants> getBySocialNetworks(SocialNetworks socialNetworks)throws NoAboutBySocialNetworkExc{
        List<AboutRestaurants> restaurantsList =
                aboutRestaurantRepository.findBySocialNetworks(socialNetworks);

        if(restaurantsList.isEmpty()){
            throw new NoAboutBySocialNetworkExc(socialNetworks);
        }

        return restaurantsList;
    }
}
