package com.example.MyMenu.entity;

import com.example.MyMenu.entity.images.RestaurantsImage;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "restaurans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String restauransName;

    private String Description;

    private String workHours;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RestaurantsImage> imageList;


}
