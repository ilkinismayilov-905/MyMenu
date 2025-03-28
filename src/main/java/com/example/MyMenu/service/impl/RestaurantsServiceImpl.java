package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.restauants.Restaurants;
import com.example.MyMenu.service.RestaurantsService;

import java.util.List;
import java.util.Optional;

public class RestaurantsServiceImpl implements RestaurantsService {
    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Restaurants save(Restaurants entity) {
        return null;
    }

    @Override
    public Optional<Restaurants> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Restaurants> getAll() {
        return List.of();
    }
}
