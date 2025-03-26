package com.example.MyMenu.entity.images;

import com.example.MyMenu.entity.Blog;
import com.example.MyMenu.entity.Restaurants;
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

    @Column(nullable = false,length = 600)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "restaurant_id",nullable = false)
    private Restaurants restaurants;
}
