package com.example.MyMenu.controller;

import com.example.MyMenu.entity.about.AboutWebsite;
import com.example.MyMenu.service.impl.AboutWebsiteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/about")
public class AboutWebsiteController {

    private static final Logger logger = LoggerFactory.getLogger(AboutWebsiteController.class);

    private final AboutWebsiteServiceImpl aboutWebsiteServiceImpl;

    @Autowired
    public AboutWebsiteController(AboutWebsiteServiceImpl aboutWebsiteServiceImpl) {
        this.aboutWebsiteServiceImpl = aboutWebsiteServiceImpl;
    }

    @Operation(summary = "Add new sloagn")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Slogan is added"),
            @ApiResponse(responseCode = "404" , description = "Slogan could not be added")
    }
    )
    @PostMapping("/add")
    public ResponseEntity<AboutWebsite> add(@RequestBody AboutWebsite aboutWebsite){
        logger.info("Successfully added");
        return ResponseEntity.ok(aboutWebsiteServiceImpl.save(aboutWebsite));
    }

    @Operation(summary = "Get all slogans")
    @GetMapping("/getAll")
    public ResponseEntity<List<AboutWebsite>> getAll(){
        logger.info("Get all slogans");
       return ResponseEntity.ok( aboutWebsiteServiceImpl.getAll()) ;
    }

    @Operation(summary = "Get slogan by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Slogan is found by id"),
            @ApiResponse(responseCode = "404" , description = "Slogan is not found by id")
    })
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<AboutWebsite>> getById(@PathVariable Long id){
        Optional<AboutWebsite> aboutWebsite = aboutWebsiteServiceImpl.getById(id);


        return ResponseEntity.ok(aboutWebsite);
    }

    @Operation(summary = "Delete slogan by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Slogan is deleted by id"),
            @ApiResponse(responseCode = "404" , description = "Slogan is not deleted by id")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<AboutWebsite>> deleteById(@PathVariable Long id){
        Optional<AboutWebsite> aboutWebsite = aboutWebsiteServiceImpl.getById(id);

        aboutWebsiteServiceImpl.deleteById(id);

        return ResponseEntity.ok(aboutWebsite);
    }
}
