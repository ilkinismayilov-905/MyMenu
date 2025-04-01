package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.images.FoodImage;
import com.example.MyMenu.exceptions.EmptyListException;
import com.example.MyMenu.exceptions.NoEntityByIdException;
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
    public void deleteById(Long id) throws NoEntityByIdException {
        if(foodImageRepository.existsById(id)){
            foodImageRepository.deleteById(id);
        }else{
            throw new NoEntityByIdException(id);
        }
    }

    @Override
    public FoodImage save(FoodImage entity) {
        return foodImageRepository.save(entity);
    }

    @Override
    public Optional<FoodImage> getById(Long id) throws NoEntityByIdException {
        Optional<FoodImage> foodImage = foodImageRepository.findById(id);

        if(foodImage.isEmpty()){
            throw new NoEntityByIdException(id);
        }
        return foodImage;
    }

    @Override
    public List<FoodImage> getAll() throws EmptyListException {

        List<FoodImage> list = foodImageRepository.findAll();

        if(list.isEmpty()){
            throw new EmptyListException();
        }
        return list;
    }
}
