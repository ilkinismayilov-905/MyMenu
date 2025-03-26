package com.example.MyMenu.entity.about;

import com.example.MyMenu.enums.Facilities;
import com.example.MyMenu.enums.SocialNetworks;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "about_restaurant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutRestaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Facilities facilities;

    @Enumerated(value = EnumType.STRING)
    private SocialNetworks socialNetworks;
}
