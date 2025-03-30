package com.example.MyMenu.repository;

import com.example.MyMenu.entity.about.AboutRestaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRestaurantRepository extends JpaRepository<AboutRestaurants,Long> {
    public AboutRestaurants findByFacilities(String facilities);
    public AboutRestaurants findBySocialNetworks(String socialNetworks);
}
