package com.example.MyMenu.entity.about;

import com.example.MyMenu.enums.Facilities;
import com.example.MyMenu.enums.SocialNetworks;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity(name = "about_restaurant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutRestaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ElementCollection(targetClass = Facilities.class)
    @Enumerated(value = EnumType.STRING)
    private Set<Facilities> facilities;

    @ElementCollection(targetClass = SocialNetworks.class)
    @Enumerated(value = EnumType.STRING)
    private Set<SocialNetworks> socialNetworks;
}
