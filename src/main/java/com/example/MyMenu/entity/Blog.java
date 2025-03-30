package com.example.MyMenu.entity;

import com.example.MyMenu.entity.images.FoodImage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany
    private List<FoodImage> images = new ArrayList<>();

    public Blog(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
