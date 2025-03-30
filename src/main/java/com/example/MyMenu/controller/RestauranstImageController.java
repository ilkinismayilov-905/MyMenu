package com.example.MyMenu.controller;

import com.example.MyMenu.entity.images.FoodImage;
import com.example.MyMenu.entity.images.RestaurantsImage;
import com.example.MyMenu.service.RestaurantsImageService;
import com.example.MyMenu.service.impl.RestaurantsImageServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantImage")
public class RestauranstImageController {

    private final RestaurantsImageServiceImpl restaurantsImageServiceImpl;

    @Autowired
    public RestauranstImageController(RestaurantsImageServiceImpl restaurantsImageServiceImpl) {
        this.restaurantsImageServiceImpl = restaurantsImageServiceImpl;
    }

    @Operation(summary = "Add new RestaurantImage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "RestaurantImage is added"),
            @ApiResponse(responseCode = "404" , description = "RestaurantImage cannot added")
    }
    )
    @PostMapping("/add")
    public ResponseEntity<RestaurantsImage> addImage(@Valid @RequestBody RestaurantsImage restaurantsImage){
        restaurantsImageServiceImpl.save(restaurantsImage);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get all RestaurantsImages")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "RestaurantImages is found"),
            @ApiResponse(responseCode = "404" , description = "There is no RestaurantImages")

    }
    )
    @GetMapping("/allImages")
    public ResponseEntity<List<RestaurantsImage>> getAll(){
        return ResponseEntity.ok(restaurantsImageServiceImpl.getAll());
    }

    @Operation(summary = "Get RestaurantsImages by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "RestaurantImages is found"),
            @ApiResponse(responseCode = "404" , description = "There is no RestaurantImages")

    }
    )
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<RestaurantsImage>> getImageById(@PathVariable Long id){
        Optional<RestaurantsImage> image = restaurantsImageServiceImpl.getById(id);

        return ResponseEntity.ok(image);
    }

    @Operation(summary = "Delete RestaurantImage by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "RestaurantImage is deleted"),
            @ApiResponse(responseCode = "404" , description = "RestaurantImage couldn't deleted")
    }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<RestaurantsImage>> deleteById(@PathVariable Long id){
        Optional<RestaurantsImage> image = restaurantsImageServiceImpl.getById(id);

        restaurantsImageServiceImpl.deleteById(id);
        return ResponseEntity.ok(image);
    }
}
