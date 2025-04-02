//package com.example.MyMenu.service.impl;
//
//import com.example.MyMenu.entity.Rating;
//import com.example.MyMenu.entity.Restaurants;
//import com.example.MyMenu.entity.UserEntity;
//import com.example.MyMenu.exceptions.NoEntityByIdException;
//import com.example.MyMenu.exceptions.RestaurantNotFoundException;
//import com.example.MyMenu.exceptions.UserNotFoundException;
//import com.example.MyMenu.repository.RatingRepository;
//import com.example.MyMenu.repository.RestaurantsRepository;
//import com.example.MyMenu.repository.UserEntityRepository;
//import com.example.MyMenu.service.RatingService;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional
//public class RatingServiceImpl implements RatingService {
//
//    private final RatingRepository ratingRepository;
//
//    private final RestaurantsRepository restaurantsRepository;
//
//    private final UserEntityRepository userEntityRepository;
//
//    @Autowired
//    public RatingServiceImpl(RatingRepository ratingRepository, RestaurantsRepository restaurantsRepository, UserEntityRepository userEntityRepository) {
//        this.ratingRepository = ratingRepository;
//        this.restaurantsRepository = restaurantsRepository;
//        this.userEntityRepository = userEntityRepository;
//    }
//
//    public Optional<Rating> rateRestaurant(Rating rating){
//        Optional<UserEntity> user = Optional.ofNullable(userEntityRepository.findById(rating.getUserId().getId())
//                .orElseThrow(UserNotFoundException::new));
//
//
//        Optional<Restaurants> restaurant = Optional.ofNullable(restaurantsRepository.findById(rating.getRestaurantId().getId())
//                .orElseThrow(RestaurantNotFoundException::new));
//
//        UserEntity newUser = user.orElseThrow(() -> new RuntimeException("User not found"));
//        Restaurants newRestaurant = restaurant.orElseThrow(() -> new RuntimeException("Restaurant not found"));
//
//
//        Rating existingRating = ratingRepository.findByUserIdAndRestaurantId(newUser, newRestaurant)
//                .orElse(null);
//
//
//        if(existingRating !=null){
//            existingRating.setRatingScore(rating.getRatingScore());
//            return Optional.of(ratingRepository.save(existingRating));
//        }else {
//            Rating newRating = new Rating();
//            newRating.setUserId(newUser);
//            newRating.setRestaurantId(newRestaurant);
//            newRating.setRatingScore(rating.getRatingScore());
//
//            return Optional.of(ratingRepository.save(newRating));
//
//
//        }
//    }
//
//    public List<Rating> getRatingsByRestaurant(Long restaurantId) throws NoEntityByIdException{
//
//        List<Rating> list = ratingRepository.findRestaurantById(restaurantId);
//
//        if(list.isEmpty()){
//            throw new NoEntityByIdException(restaurantId);
//        }
//
//        return list;
//    }
//}
