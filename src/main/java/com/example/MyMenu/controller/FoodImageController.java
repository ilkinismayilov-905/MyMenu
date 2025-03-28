package com.example.MyMenu.controller;

import com.example.MyMenu.entity.UserEntity;
import com.example.MyMenu.entity.images.FoodImage;
import com.example.MyMenu.service.impl.FoodImageServiceImpl;
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
@RequestMapping("/foodImage")
public class FoodImageController {
    private final FoodImageServiceImpl foodImageServiceImpl;

    @Autowired
    public FoodImageController(FoodImageServiceImpl foodImageServiceImpl) {
        this.foodImageServiceImpl = foodImageServiceImpl;
    }

    @Operation(summary = "Add new FoodImage")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "FoodImage added"),
            @ApiResponse(responseCode = "404" , description = "FoodImage cannot added")
    }
    )
    @PostMapping("/add")
    public ResponseEntity<FoodImage> addFood(@Valid @RequestBody FoodImage foodImage){
        foodImageServiceImpl.save(foodImage);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get FoodImage by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "FoodImage found"),
            @ApiResponse(responseCode = "404" , description = "FoodImage not found")

    }
    )
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<FoodImage>> getFoodImageById(@PathVariable Long id){
        Optional<FoodImage> foodImage = foodImageServiceImpl.getById(id);
        if(foodImage.isEmpty()){
            throw new RuntimeException("Error");
        }
        return ResponseEntity.ok(foodImage);
    }

    @Operation(summary = "Get all FoodImages")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "FoodImage found"),
            @ApiResponse(responseCode = "404" , description = "There is no FoodImage")

    }
    )
    @GetMapping("/allImages")
    public ResponseEntity<List<FoodImage>> getAll(){
        return ResponseEntity.ok(foodImageServiceImpl.getAll());
    }

    @Operation(summary = "Delete FoodImage by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "FoodImage deleted"),
            @ApiResponse(responseCode = "404" , description = "FoodImage couldn't deleted")
    }
    )

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Optional<FoodImage>> deleteById(@PathVariable Long id){
        Optional<FoodImage> foodImage = foodImageServiceImpl.getById(id);

        if(foodImage.isEmpty()){
            throw new RuntimeException("Error");
        }
        foodImageServiceImpl.deleteById(id);
        return ResponseEntity.ok(foodImage);
    }

}
