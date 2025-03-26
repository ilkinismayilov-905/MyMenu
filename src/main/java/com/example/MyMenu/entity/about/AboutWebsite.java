package com.example.MyMenu.entity.about;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(name = "about")
@Data
@AllArgsConstructor
@NotNull
public class AboutWebsite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String slogan;

    @Column(columnDefinition = "TEXT")
    private String description;
}
