package com.example.MyMenu.service;

import com.example.MyMenu.entity.Restaurants;
import com.example.MyMenu.dtos.RestaurantsDTO;

import java.util.Optional;

public interface RestaurantsService extends GeneralService<Restaurants, Long> {
     Restaurants create(RestaurantsDTO restaurantsDTO);
//     Optional<Restaurants> updateById(Long id,RestaurantsDTO restaurantsDTO);
}
