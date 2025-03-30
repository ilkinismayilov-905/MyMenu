package com.example.MyMenu.entity;

import com.example.MyMenu.enums.AddressCity;
import com.example.MyMenu.enums.AddressDistrict;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @Enumerated(EnumType.STRING)
    private AddressCity city;

    @Enumerated(EnumType.STRING)
    private AddressDistrict district;


}
