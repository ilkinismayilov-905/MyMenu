package com.example.MyMenu.controller;

import com.example.MyMenu.entity.Address;
import com.example.MyMenu.enums.AddressCity;
import com.example.MyMenu.enums.AddressDistrict;
import com.example.MyMenu.service.impl.AdressServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/address")
public class AddressController {

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    private final AdressServiceImpl adressServiceImpl;

    @Autowired
    public AddressController(AdressServiceImpl adressServiceImpl) {
        this.adressServiceImpl = adressServiceImpl;
    }

    @Operation(summary = "Add new address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Address is added"),
            @ApiResponse(responseCode = "404" , description = "Address could not added")

    }
    )
    @PostMapping("/add")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){

       Address createdAddress = adressServiceImpl.save(address);


        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all Address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Addresses are found"),
            @ApiResponse(responseCode = "404" , description = "There is no address")
    }
    )
    @GetMapping("/getAll")
    public ResponseEntity<List<Address>> getAll(){

        List<Address> addressList = adressServiceImpl.getAll();

        logger.info("GetAll address");


        return ResponseEntity.ok(addressList);
    }

    @Operation(summary = "Get Address by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Address is found by ID"),
            @ApiResponse(responseCode = "404" , description = "There is no address by id")
    }
    )
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Address>> getById(@PathVariable Long id){

        Optional<Address> address = adressServiceImpl.getById(id);

        return ResponseEntity.ok(address);
    }

    @Operation(summary = "Delete Address by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Address is deleted by ID"),
            @ApiResponse(responseCode = "404" , description = "There is no address by id")
    }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Address>> deleteById(@PathVariable Long id){
        Optional<Address> address = adressServiceImpl.getById(id);
        adressServiceImpl.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get Address by City")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Address is found by city"),
            @ApiResponse(responseCode = "404" , description = "There is no address by city")
    }
    )
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Address>> getByCity(@PathVariable AddressCity city){
        return ResponseEntity.ok(adressServiceImpl.getByCity(city));
    }

    @Operation(summary = "Get Address by District")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Address is found by district"),
            @ApiResponse(responseCode = "404" , description = "There is no address by district")
    }
    )
    @GetMapping("/district/{district}")
    public ResponseEntity<List<Address>> getByDistrict(@PathVariable AddressDistrict district){
        return ResponseEntity.ok(adressServiceImpl.getByDistrict(district));
    }

    @GetMapping("/cities")
    public ResponseEntity<List<AddressCity>> getAddressCities(){
        List<AddressCity> cityList = Arrays.asList(AddressCity.values());
        return ResponseEntity.ok(cityList);
    }

    @GetMapping("/district")
    public ResponseEntity<List<AddressDistrict>> getAddressDistrict(){
        List<AddressDistrict> cityList = Arrays.asList(AddressDistrict.values());
        return ResponseEntity.ok(cityList);
    }
}
