package com.example.MyMenu.repository;

import com.example.MyMenu.entity.images.FoodImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodImageRepository extends JpaRepository<FoodImage,Long> {
}
