//package com.example.MyMenu.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity(name = "rating")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Rating {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Integer ratingScore;
//
//    @ManyToOne
//    @Column(nullable = false)
//    private UserEntity userId;
//
//    @ManyToOne
//    private Restaurants restaurantId;
//}
