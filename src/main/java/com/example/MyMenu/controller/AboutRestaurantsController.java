package com.example.MyMenu.controller;

import com.example.MyMenu.entity.Address;
import com.example.MyMenu.entity.about.AboutRestaurants;
import com.example.MyMenu.enums.AddressCity;
import com.example.MyMenu.enums.AddressDistrict;
import com.example.MyMenu.enums.Facilities;
import com.example.MyMenu.enums.SocialNetworks;
import com.example.MyMenu.service.impl.AboutRestaurantServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aboutRestaurants")
public class AboutRestaurantsController {

    private final AboutRestaurantServiceImpl aboutRestaurantServiceImpl;

    @Autowired
    public AboutRestaurantsController(AboutRestaurantServiceImpl aboutRestaurantServiceImpl) {
        this.aboutRestaurantServiceImpl = aboutRestaurantServiceImpl;
    }

    @Operation(summary = "Add new AboutRestaurant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "AboutRestaurant is added"),
            @ApiResponse(responseCode = "404" , description = "AboutRestaurant could not be added")
    }
    )
    @PostMapping("/add")
    public ResponseEntity<AboutRestaurants> add(@RequestBody AboutRestaurants aboutRestaurants){
        return ResponseEntity.ok(aboutRestaurantServiceImpl.save(aboutRestaurants));
    }

    @Operation(summary = "Get all AboutRestaurants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "AboutRestaurant is found"),
            @ApiResponse(responseCode = "404" , description = "There is no AboutRestaurant")
    }
    )
    @GetMapping("/getAll")
    public ResponseEntity<List<AboutRestaurants>> getAll(){
        return ResponseEntity.ok(aboutRestaurantServiceImpl.getAll());
    }

    @Operation(summary = "Get AboutRestaurant by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "AboutRestaurant is found by ID"),
            @ApiResponse(responseCode = "404" , description = "There is no AboutRestaurant by id")
    }
    )
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<AboutRestaurants>> getById(@PathVariable Long id){
        return ResponseEntity.ok(aboutRestaurantServiceImpl.getById(id));
    }

    @Operation(summary = "Delete AboutRestaurant by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "AboutRestaurant is deleted by ID"),
            @ApiResponse(responseCode = "404" , description = "There is no AboutRestaurant by id")
    }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<AboutRestaurants>> deleteById(@PathVariable Long id){
        Optional<AboutRestaurants> about = aboutRestaurantServiceImpl.getById(id);
        aboutRestaurantServiceImpl.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get AboutRestaurant by Facilities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "AboutRestaurant is found by Facilities"),
            @ApiResponse(responseCode = "404" , description = "There is no AboutRestaurant by Facilities")
    }
    )
    @GetMapping("/facility/{facilities}")
    public ResponseEntity<List<AboutRestaurants>> getByFacility(@PathVariable Facilities facilities){
        return ResponseEntity.ok(aboutRestaurantServiceImpl.getByFacilities(facilities));
    }

    @Operation(summary = "Get AboutRestaurant by SocialNetwork")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "AboutRestaurant is found by SocialNetwork"),
            @ApiResponse(responseCode = "404" , description = "There is no AboutRestaurant by SocialNetwork")
    }
    )
    @GetMapping("/socialNetwork/{socialNetworks}")
    public ResponseEntity<List<AboutRestaurants>> getBySocialNetworks(@PathVariable SocialNetworks socialNetworks){
        return ResponseEntity.ok(aboutRestaurantServiceImpl.getBySocialNetworks(socialNetworks));
    }

    @Operation(summary = "Get All Facilities")
    @GetMapping("/facilities")
    public ResponseEntity<List<Facilities>> getFacilities(){
        List<Facilities> facilitiesList = Arrays.asList(Facilities.values());
        return ResponseEntity.ok(facilitiesList);
    }

    @Operation(summary = "Get All SocialNetworks")
    @GetMapping("/socialNetworks")
    public ResponseEntity<List<SocialNetworks>> getSocialNetworks(){
        List<SocialNetworks> networksList = Arrays.asList(SocialNetworks.values());
        return ResponseEntity.ok(networksList);
    }

}
