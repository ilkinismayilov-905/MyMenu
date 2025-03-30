package com.example.MyMenu.service;

import com.example.MyMenu.entity.Blog;
import com.example.MyMenu.dtos.BlogDTO;

public interface BlogService extends GeneralService<Blog, Long>{
    public Blog createBlog(BlogDTO blogDTO);
}
