package com.example.MyMenu.repository;

import com.example.MyMenu.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {
    public Optional<UserEntity> getByUsername(String username);
    public Optional<UserEntity> getByEmail(String email);
}
