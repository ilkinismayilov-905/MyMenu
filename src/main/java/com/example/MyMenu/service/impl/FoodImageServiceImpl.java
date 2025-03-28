package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.images.FoodImage;
import com.example.MyMenu.repository.FoodImageRepository;
import com.example.MyMenu.service.FoodImageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FoodImageServiceImpl implements FoodImageService {

    private final FoodImageRepository foodImageRepository;

    @Autowired
    public FoodImageServiceImpl(FoodImageRepository foodImageRepository) {
        this.foodImageRepository = foodImageRepository;
    }

    @Override
    public void deleteById(Long id) {
        if(foodImageRepository.existsById(id)){
            foodImageRepository.deleteById(id);
        }
    }

    @Override
    public FoodImage save(FoodImage entity) {
        return foodImageRepository.save(entity);
    }

    @Override
    public Optional<FoodImage> getById(Long id) {
        Optional<FoodImage> foodImage = foodImageRepository.findById(id);

        if(foodImage.isEmpty()){
            throw new RuntimeException("Error");
        }
        return foodImage;
    }

    @Override
    public List<FoodImage> getAll() {
        return foodImageRepository.findAll();
    }
}
