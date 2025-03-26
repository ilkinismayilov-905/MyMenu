package com.example.MyMenu.entity;

import com.example.MyMenu.enums.AddressCity;
import com.example.MyMenu.enums.AddressDistrict;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "user_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @Email
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Restaurans> restaurantsName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> address;

    private String password;

    private String confirmPassword;




}
