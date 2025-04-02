package com.example.MyMenu.entity;

import com.example.MyMenu.entity.images.FoodImage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "blog")
@AllArgsConstructor
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

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FoodImage> getImages() {
        return images;
    }

    public void setImages(List<FoodImage> images) {
        this.images = images;
    }
}
