package com.example.MyMenu.repository;

import com.example.MyMenu.entity.about.AboutWebsite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutWebsiteRepository extends JpaRepository<AboutWebsite,Long> {
}
