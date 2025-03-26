package com.example.MyMenu.repository;

import com.example.MyMenu.entity.SupportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportEntityRepository extends JpaRepository<SupportEntity,Long> {
}
