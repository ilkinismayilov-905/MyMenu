package com.example.MyMenu.entity.about;

import com.example.MyMenu.enums.Facilities;
import com.example.MyMenu.enums.SocialNetworks;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "about_restaurant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutRestaurants {

    @Enumerated(value = EnumType.STRING)
    private Facilities facilities;

    @Enumerated(value = EnumType.STRING)
    private SocialNetworks socialNetworks;
}
