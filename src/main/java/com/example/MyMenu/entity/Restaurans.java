package com.example.MyMenu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "restaurans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String restauransName;

    private String Description;

    private String workHours;

}
