package com.example.MyMenu.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "user_entity")
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Email
    @Column(unique = true)
    private String email;

    private String password;

//    @OneToMany
//    private List<Rating> ratings;

    @JsonCreator
    public UserEntity(@JsonProperty("id") Long id,
                      @JsonProperty("username") String username,
                      @JsonProperty("email") String email,
                      @JsonProperty("password") String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
