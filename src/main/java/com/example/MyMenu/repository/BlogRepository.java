package com.example.MyMenu.repository;

import com.example.MyMenu.entity.blogs.Blog;
import com.example.MyMenu.entity.blogs.BlogDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    public Optional<Blog> getByTitle(String title);

}
