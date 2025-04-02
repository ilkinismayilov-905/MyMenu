package com.example.MyMenu.repository;

import com.example.MyMenu.entity.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurants,Long> {
    List<Restaurants> findByRestaurantName(String restaurantName);
    Restaurants getRestaurantById(Long id);
}
