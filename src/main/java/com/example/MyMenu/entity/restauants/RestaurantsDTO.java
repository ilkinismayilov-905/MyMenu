package com.example.MyMenu.entity.restauants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantsDTO {

    private String title;
    private String description;
    private List<Long> imageIds;
}
