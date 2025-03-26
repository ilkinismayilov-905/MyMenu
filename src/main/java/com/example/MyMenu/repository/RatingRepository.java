package com.example.MyMenu.repository;

import com.example.MyMenu.entity.Rating;
import com.example.MyMenu.entity.about.AboutRestaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {
}
