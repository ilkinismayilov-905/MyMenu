package com.example.MyMenu.repository;

import com.example.MyMenu.entity.restauants.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurants,Long> {
//    public Optional<Restaurants> findByName(String restaurantName);
}
