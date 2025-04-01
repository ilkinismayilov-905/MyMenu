package com.example.MyMenu.controller;

import com.example.MyMenu.entity.Rating;
import com.example.MyMenu.service.RatingService;
import com.example.MyMenu.service.impl.RatingServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingServiceImpl ratingServiceImpl;

    @Autowired
    public RatingController(RatingServiceImpl ratingServiceImpl) {
        this.ratingServiceImpl = ratingServiceImpl;
    }

    @Operation(summary = "Add new Rating")
    @PostMapping("/rate")
    public ResponseEntity<Optional<Rating>> rateRestaurant(@RequestBody Rating rating){
        Optional<Rating> rate = ratingServiceImpl.rateRestaurant(rating);

        return ResponseEntity.ok(rate);
    }

    @Operation(summary = "Get all ratings")
    @GetMapping("/restaurantId/{restaurantId}")
    public ResponseEntity<List<Rating>> getRatingsForRestaurant(@PathVariable Long restaurantId) {
        return ResponseEntity.ok( ratingServiceImpl.getRatingsByRestaurant(restaurantId)) ;
    }
}
