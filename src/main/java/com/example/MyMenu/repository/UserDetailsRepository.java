package com.example.MyMenu.repository;

import com.example.MyMenu.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {
    public Optional<UserDetails> findUserByName(String name);
    public Optional<UserDetails> findUserBySurname(String surname);
    public Optional<UserDetails> findUserByEmail(String email);
}
