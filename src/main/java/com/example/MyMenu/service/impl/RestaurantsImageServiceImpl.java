package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.images.RestaurantsImage;
import com.example.MyMenu.exceptions.EmptyListException;
import com.example.MyMenu.exceptions.NoEntityByIdException;
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
    public void deleteById(Long id) throws NoEntityByIdException {
        if(restaurantsImageRepository.existsById(id)){
            restaurantsImageRepository.deleteById(id);
        }else {
            throw new NoEntityByIdException(id);
        }
    }

    @Override
    public RestaurantsImage save(RestaurantsImage entity) {
        return restaurantsImageRepository.save(entity);
    }

    @Override
    public Optional<RestaurantsImage> getById(Long id) throws NoEntityByIdException {
        Optional<RestaurantsImage> image = restaurantsImageRepository.findById(id);

        if(image.isEmpty()){
            throw new NoEntityByIdException(id);
        }

        return image;
    }

    @Override
    public List<RestaurantsImage> getAll() throws EmptyListException {
        List<RestaurantsImage> list = restaurantsImageRepository.findAll();

        if(list.isEmpty()){
            throw new EmptyListException();
        }
        return list;
    }
}
