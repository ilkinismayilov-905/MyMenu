package com.example.MyMenu.entity.images;

import com.example.MyMenu.entity.restauants.Restaurants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "restaurant_image")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantsImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String imageUrl;
}
