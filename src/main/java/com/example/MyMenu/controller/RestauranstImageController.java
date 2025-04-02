package com.example.MyMenu.controller;


import com.example.MyMenu.entity.images.RestaurantsImage;
import com.example.MyMenu.service.impl.RestaurantsImageServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantImage")
public class RestauranstImageController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private static final Logger logger = LoggerFactory.getLogger(RestauranstImageController.class);

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
    public ResponseEntity<RestaurantsImage> addImage(@Valid @RequestBody RestaurantsImage restaurantsImage) throws IOException {
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
    public ResponseEntity<List<RestaurantsImage>> getAll() throws MalformedURLException {

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

    @GetMapping("/images/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        try {
            Path filePath = Paths.get(uploadDir).resolve(filename);
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/images")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Save the file to the directory
            String filePath = restaurantsImageServiceImpl.saveImage(file);

            RestaurantsImage image = new RestaurantsImage();
            image.setImageUrl(filePath);
            image.setId(image.getId());
            restaurantsImageServiceImpl.save(image);

            return ResponseEntity.ok("Image uploaded successfully: " + filePath);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }
    }

//    private String saveImage(MultipartFile file) throws IOException {
//        Path uploadPath = Paths.get(uploadDir);
//        if (!Files.exists(uploadPath)) {
//            Files.createDirectories(uploadPath);
//        }
//
//        String fileName = file.getOriginalFilename();
//        Path filePath = uploadPath.resolve(fileName);
//        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//        return filePath.toString();
//    }
}
