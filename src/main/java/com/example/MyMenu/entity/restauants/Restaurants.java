package com.example.MyMenu.entity.restauants;

import com.example.MyMenu.entity.Address;
import com.example.MyMenu.entity.about.AboutRestaurants;
import com.example.MyMenu.entity.images.RestaurantsImage;
import com.example.MyMenu.enums.AddressCity;
import com.example.MyMenu.enums.AddressDistrict;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "restaurans")
@Data
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



}
