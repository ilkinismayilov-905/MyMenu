package com.example.MyMenu.dtos;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class RestaurantsDTO {

    private String restaurantName;
    private String description;
    private String workHours;
    private List<Long> imageIds;
    private List<Long> addressIds;
    private List<Long> about;

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

    public List<Long> getImageIds() {
        return imageIds;
    }

    public void setImageIds(List<Long> imageIds) {
        this.imageIds = imageIds;
    }

    public List<Long> getAddressIds() {
        return addressIds;
    }

    public void setAddressIds(List<Long> addressIds) {
        this.addressIds = addressIds;
    }

    public List<Long> getAbout() {
        return about;
    }

    public void setAbout(List<Long> about) {
        this.about = about;
    }

    //    public RestaurantsDTO getAddress() {
//        return restaurantsDTO;
//    }
}
