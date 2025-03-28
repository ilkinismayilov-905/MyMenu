package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.images.RestaurantsImage;
import com.example.MyMenu.repository.RestaurantsImageRepository;
import com.example.MyMenu.service.RestaurantsImageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestaurantsImageServiceImpl implements RestaurantsImageService {

    private final RestaurantsImageRepository restaurantsImageRepository;

    @Autowired
    public RestaurantsImageServiceImpl(RestaurantsImageRepository restaurantsImageRepository) {
        this.restaurantsImageRepository = restaurantsImageRepository;
    }

    @Override
    public void deleteById(Long id) {
        if(restaurantsImageRepository.existsById(id)){
            restaurantsImageRepository.deleteById(id);
        }
    }

    @Override
    public RestaurantsImage save(RestaurantsImage entity) {
        return restaurantsImageRepository.save(entity);
    }

    @Override
    public Optional<RestaurantsImage> getById(Long id) {
        Optional<RestaurantsImage> image = restaurantsImageRepository.findById(id);

        if(image.isEmpty()){
            throw new RuntimeException("Error");
        }

        return image;
    }

    @Override
    public List<RestaurantsImage> getAll() {
        return restaurantsImageRepository.findAll();
    }
}
