package com.example.MyMenu.service;

import com.example.MyMenu.entity.blogs.Blog;
import com.example.MyMenu.entity.blogs.BlogDTO;

public interface BlogService extends GeneralService<Blog, Long>{
    public Blog createBlog(BlogDTO blogDTO);
}
