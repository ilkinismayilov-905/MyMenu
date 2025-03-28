package com.example.MyMenu.entity;

import com.example.MyMenu.entity.restauants.Restaurants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rate;

    @OneToOne
    private UserEntity userId;

    @OneToOne
    private Restaurants restaurantId;
}
