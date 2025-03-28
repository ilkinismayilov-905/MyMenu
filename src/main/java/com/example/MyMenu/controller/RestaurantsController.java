package com.example.MyMenu.controller;

import com.example.MyMenu.entity.blogs.Blog;
import com.example.MyMenu.entity.restauants.Restaurants;
import com.example.MyMenu.entity.restauants.RestaurantsDTO;
import com.example.MyMenu.service.impl.RestaurantsImageServiceImpl;
import com.example.MyMenu.service.impl.RestaurantsServiceImpl;
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
@RequestMapping("/restaurants")
public class RestaurantsController {

    private final RestaurantsServiceImpl restaurantsServiceImpl;


    @Autowired
    public RestaurantsController(RestaurantsServiceImpl restaurantsServiceImpl) {
        this.restaurantsServiceImpl = restaurantsServiceImpl;
    }

    @Operation(summary = "Get all restaurants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Restaurants found"),
            @ApiResponse(responseCode = "404" , description = "There is no restaurant")

    }
    )
    @GetMapping("/getAll")
    public ResponseEntity<List<Restaurants>> getAll(){
        return ResponseEntity.ok(restaurantsServiceImpl.getAll());
    }

    @Operation(summary = "Add new restaurant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Restaurant added"),
            @ApiResponse(responseCode = "404" , description = "Restaurant could not added")
    }
    )
    @PostMapping("/add")
    public ResponseEntity<Restaurants> addRestaurant(@Valid @RequestBody RestaurantsDTO restaurantsDTO){
        restaurantsServiceImpl.create(restaurantsDTO);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get restaurant by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Restaurant found by ID"),
            @ApiResponse(responseCode = "404" , description = "Restaurans could not found by ID")
    }
    )
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Restaurants>> findById(@PathVariable Long id){
        Optional<Restaurants> restaurants = restaurantsServiceImpl.getById(id);

        return ResponseEntity.ok(restaurants);
    }

//    @Operation(summary = "Get restaurant by name")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200" , description = "Restaurant found by name"),
//            @ApiResponse(responseCode = "404" , description = "Restaurant could not found by name")
//    }
//    )
//    @GetMapping("/name/{name}")
//    public ResponseEntity<Optional<Restaurants>> findByName(@PathVariable String restaurantName){
//        Optional<Restaurants> restaurants = restaurantsServiceImpl.getByName(restaurantName);
//
//        return ResponseEntity.ok(restaurants);
//    }

    @Operation(summary = "Delete restaurant by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Restaurant deleted by ID"),
            @ApiResponse(responseCode = "404" , description = "Restaurant could not deleted by ID")
    }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Restaurants>> deleteById(@PathVariable Long id){
        Optional<Restaurants> restaurants = restaurantsServiceImpl.getById(id);

        restaurantsServiceImpl.deleteById(id);
        return ResponseEntity.ok(restaurants);
    }



}
