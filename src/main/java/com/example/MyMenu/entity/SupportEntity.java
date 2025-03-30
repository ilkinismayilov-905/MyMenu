package com.example.MyMenu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "support")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 30)
    private String fullname;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(length = 300)
    private String text;

    private Long number;




}
