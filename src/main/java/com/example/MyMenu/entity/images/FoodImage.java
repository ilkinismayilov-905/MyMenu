package com.example.MyMenu.entity.images;

import com.example.MyMenu.entity.Blog;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "image")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,length = 600)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "blog_id",nullable = false)
    private Blog blog;
}
