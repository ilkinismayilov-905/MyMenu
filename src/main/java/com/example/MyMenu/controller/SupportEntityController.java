package com.example.MyMenu.controller;

import com.example.MyMenu.entity.SupportEntity;
import com.example.MyMenu.entity.UserEntity;
import com.example.MyMenu.entity.images.RestaurantsImage;
import com.example.MyMenu.service.impl.SupportEntityServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/support")
public class SupportEntityController {
    private static final Logger logger = LoggerFactory.getLogger(SupportEntityController.class);

    private final SupportEntityServiceImpl supportEntityServiceImpl;

    @Autowired
    public SupportEntityController(SupportEntityServiceImpl supportEntityServiceImpl) {
        this.supportEntityServiceImpl = supportEntityServiceImpl;
    }

    @Operation(summary = "Get all supports")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Supports are found"),
            @ApiResponse(responseCode = "404" , description = "There are no Supports")

    }
    )
    @GetMapping("/getAll")
    public ResponseEntity<List<SupportEntity>> getAll(){
        return ResponseEntity.ok(supportEntityServiceImpl.getAll());
    }

    @Operation(summary = "Add new support")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Support is added"),
            @ApiResponse(responseCode = "404" , description = "Support couldn not added")

    }
    )
    @PostMapping("/add")
    public ResponseEntity<SupportEntity> createUser(@Valid @RequestBody SupportEntity supportEntity){
        supportEntityServiceImpl.save(supportEntity);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get support by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Support is found"),
            @ApiResponse(responseCode = "404" , description = "Support is not found")

    }
    )
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<SupportEntity>> getUserById(@PathVariable Long id){
        Optional<SupportEntity> support = supportEntityServiceImpl.getById(id);

        return ResponseEntity.ok(support);
    }

    @Operation(summary = "Delete support by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Support is deleted"),
            @ApiResponse(responseCode = "404" , description = "Support couldn't deleted")
    }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<SupportEntity>> deleteById(@PathVariable Long id){
        Optional<SupportEntity> image = supportEntityServiceImpl.getById(id);

        supportEntityServiceImpl.deleteById(id);
        return ResponseEntity.ok(image);
    }

}
