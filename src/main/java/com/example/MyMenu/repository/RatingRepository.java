//package com.example.MyMenu.repository;
//
//import com.example.MyMenu.entity.Rating;
//import com.example.MyMenu.entity.Restaurants;
//import com.example.MyMenu.entity.UserEntity;
//import com.example.MyMenu.entity.about.AboutRestaurants;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface RatingRepository extends JpaRepository<Rating,Long> {
//    List<Rating> findRestaurantById(Long restaurantId);
//
//    Optional<Rating> findByUserIdAndRestaurantId(UserEntity user, Restaurants restaurants);
//}
