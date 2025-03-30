package com.example.MyMenu.service;

import com.example.MyMenu.entity.restauants.Restaurants;
import com.example.MyMenu.entity.restauants.RestaurantsDTO;

import java.util.Optional;

public interface RestaurantsService extends GeneralService<Restaurants, Long> {
    public Restaurants create(RestaurantsDTO restaurantsDTO);
    public Optional<Restaurants> updateById(Long id,RestaurantsDTO restaurantsDTO);
}
