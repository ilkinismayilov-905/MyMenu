package com.example.MyMenu.controller;

import com.example.MyMenu.entity.UserDetails;

import com.example.MyMenu.entity.UserEntity;
import com.example.MyMenu.service.impl.UserDetailsServiceImpl;
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
@RequestMapping("/userDetails")
public class UserDetailsController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    public UserDetailsController(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Operation(summary = "Add New UserDetails")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "UserDetails added succesfully"),
            @ApiResponse(responseCode = "404" , description = "UserDetails cannot added")
    }
    )
    @PostMapping("/add")
    public ResponseEntity<UserDetails> createUser(@Valid @RequestBody UserDetails user){
        userDetailsServiceImpl.save(user);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get all users")
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDetails>> getAll() {
        return ResponseEntity.ok( userDetailsServiceImpl.getAll());
    }

    @Operation(summary = "Delete user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "UserDetails deleted succesfully"),
            @ApiResponse(responseCode = "404" , description = "UserDetails cannot deleted")
    }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<UserDetails>> deleteById(@PathVariable Long id){
        Optional<UserDetails> userDetails = userDetailsServiceImpl.getById(id);

        userDetailsServiceImpl.deleteById(id);

        return ResponseEntity.ok(userDetails);
    }

    @Operation(summary = "Find user by Name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "UserDetails found by name"),
            @ApiResponse(responseCode = "404" , description = "UserDetails cannot found by name")
    }
    )
    @GetMapping("/name/{name}")
    public ResponseEntity<Optional<UserDetails>> getName(@PathVariable String name){
        Optional<UserDetails> userDetails = userDetailsServiceImpl.getUserByName(name);

        return ResponseEntity.ok(userDetails);
    }


    @Operation(summary = "Find user by surname")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "UserDetails found by surname"),
            @ApiResponse(responseCode = "404" , description = "UserDetails cannot found by surname")
    }
    )
    @GetMapping("/surname/{surname}")
    public ResponseEntity<Optional<UserDetails>> getBySurname(@PathVariable String surname){
        Optional<UserDetails> userDetails = userDetailsServiceImpl.getUserBySurname(surname);

        return ResponseEntity.ok(userDetails);
    }

    @Operation(summary = "Find user by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "UserDetails found by email"),
            @ApiResponse(responseCode = "404" , description = "UserDetails cannot found by email")
    }
    )
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<UserDetails>> getByEmail(@PathVariable String email){
        Optional<UserDetails> userDetails = userDetailsServiceImpl.getUserByEmail(email);

        return ResponseEntity.ok(userDetails);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<UserDetails>> getUserById(@PathVariable Long id){
        Optional<UserDetails> user = userDetailsServiceImpl.getById(id);

        return ResponseEntity.ok(user);
    }

}
