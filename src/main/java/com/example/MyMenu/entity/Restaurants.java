package com.example.MyMenu.entity;

import com.example.MyMenu.entity.about.AboutRestaurants;
import com.example.MyMenu.entity.images.RestaurantsImage;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "restaurans")
@AllArgsConstructor
@NoArgsConstructor
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "restaurant_name")
    private String restaurantName;

    private String description;

    private String workHours;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RestaurantsImage> imageList = new ArrayList<>();

   @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Address> addressList = new ArrayList<>();

   @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<AboutRestaurants> about = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public List<RestaurantsImage> getImageList() {
        return imageList;
    }

    public void setImageList(List<RestaurantsImage> imageList) {
        this.imageList = imageList;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<AboutRestaurants> getAbout() {
        return about;
    }

    public void setAbout(List<AboutRestaurants> about) {
        this.about = about;
    }

    //   @OneToMany
//    private List<Rating> ratings = new ArrayList<>();



}
