package com.example.MyMenu.controller;

import com.example.MyMenu.entity.UserEntity;
import com.example.MyMenu.service.impl.UserEntityServiceImpl;
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
@RequestMapping("/login")
public class UserEntityController {

    private final UserEntityServiceImpl userEntityServiceImpl;

    @Autowired
    public UserEntityController(UserEntityServiceImpl userEntityServiceImpl) {
        this.userEntityServiceImpl = userEntityServiceImpl;
    }

    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Users found"),
            @ApiResponse(responseCode = "404" , description = "There is no user")

    }
    )
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserEntity>> getAll(){
        return ResponseEntity.ok(userEntityServiceImpl.getAll());
    }

    @Operation(summary = "Create user")
    @PostMapping("/add")
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserEntity user){
        userEntityServiceImpl.save(user);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "User found"),
            @ApiResponse(responseCode = "404" , description = "User not found")

    }
    )
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<UserEntity>> getUserById(@PathVariable Long id){
        Optional<UserEntity> user = userEntityServiceImpl.getById(id);
        if(user.isEmpty()){
            throw new RuntimeException("Error");
        }
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Get user by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "User found by name"),
            @ApiResponse(responseCode = "200" , description = "User not found by name")
    }
    )
    @GetMapping("/username/{username}")
    public ResponseEntity<Optional<UserEntity>> getUserByUsername(@PathVariable String username){
        Optional<UserEntity> user = userEntityServiceImpl.getByUsername(username);

        if(user.isEmpty()){
            throw new RuntimeException("Error");
        }
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Get user by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "User found by email"),
            @ApiResponse(responseCode = "200" , description = "User not found by email")
    }
    )
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<UserEntity>> getUserByEmail(@PathVariable String email){
        Optional<UserEntity> user = userEntityServiceImpl.getByEmail(email);

        if(user.isEmpty()){
            throw new RuntimeException("Error");
        }
        return ResponseEntity.ok(user);
    }
}
