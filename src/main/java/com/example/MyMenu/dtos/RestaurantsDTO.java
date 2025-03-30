package com.example.MyMenu.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantsDTO {

    private String restaurantName;
    private String description;
    private String workHours;
    private List<Long> imageIds;
    private List<Long> addressIds;
    private List<Long> about;

//    public RestaurantsDTO getAddress() {
//        return restaurantsDTO;
//    }
}
