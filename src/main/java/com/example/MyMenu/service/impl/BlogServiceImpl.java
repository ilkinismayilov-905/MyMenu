package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.blogs.Blog;
import com.example.MyMenu.entity.blogs.BlogDTO;
import com.example.MyMenu.entity.images.FoodImage;
import com.example.MyMenu.repository.BlogRepository;
import com.example.MyMenu.repository.FoodImageRepository;
import com.example.MyMenu.service.BlogService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final FoodImageRepository foodImageRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository, FoodImageRepository foodImageRepository) {
        this.blogRepository = blogRepository;
        this.foodImageRepository = foodImageRepository;
    }


    @Override
    public void deleteById(Long id) {
        if(blogRepository.existsById(id)){
            blogRepository.deleteById(id);
        }
    }

    @Override
    public Blog save(Blog entity) {
        return blogRepository.save(entity);
    }


    @Override
    public Optional<Blog> getById(Long id) {
        Optional<Blog> blog = blogRepository.findById(id);

        if(blog.isEmpty()){
            throw new RuntimeException("Error");
        }
        return blog;
    }

    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getByTitle(String title){
        Optional<Blog> blog = blogRepository.getByTitle(title);

        if (blog.isEmpty()){
            throw new RuntimeException("Error");
        }
        return blog;
    }

    @Override
    public Blog createBlog(BlogDTO blogDTO) {
        Blog blog = convertToEntity(blogDTO);

        return blogRepository.save(blog);
    }

    public Blog convertToEntity(BlogDTO blogDTO){
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setDescription(blogDTO.getDescription());

        List<FoodImage> imageList = foodImageRepository.findAllById(blogDTO.getImageIds());
        blog.setImages(imageList);

        return blog;
    }
}
