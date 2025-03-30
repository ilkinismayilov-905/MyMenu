package com.example.MyMenu.repository;

import com.example.MyMenu.entity.about.AboutRestaurants;
import com.example.MyMenu.enums.Facilities;
import com.example.MyMenu.enums.SocialNetworks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AboutRestaurantRepository extends JpaRepository<AboutRestaurants,Long> {
    public List<AboutRestaurants> findByFacilities(Facilities facilities);
    public List<AboutRestaurants> findBySocialNetworks(SocialNetworks socialNetworks);
}
