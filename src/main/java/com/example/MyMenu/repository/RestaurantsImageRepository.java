package com.example.MyMenu.repository;

import com.example.MyMenu.entity.images.RestaurantsImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantsImageRepository extends JpaRepository<RestaurantsImage,Long> {
}
