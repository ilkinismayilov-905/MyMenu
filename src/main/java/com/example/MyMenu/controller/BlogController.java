package com.example.MyMenu.controller;

import com.example.MyMenu.entity.blogs.Blog;
import com.example.MyMenu.entity.blogs.BlogDTO;
import com.example.MyMenu.service.impl.BlogServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogServiceImpl blogServiceImpl;

    @Autowired
    public BlogController(BlogServiceImpl blogServiceImpl) {
        this.blogServiceImpl = blogServiceImpl;
    }

    @Operation(summary = "Get all foods")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Food found"),
            @ApiResponse(responseCode = "404" , description = "There is no food")

    }
    )
    @GetMapping("/getAll")
    public ResponseEntity<List<Blog>> getAll(){
        return ResponseEntity.ok(blogServiceImpl.getAll());
    }

    @Operation(summary = "Add new food")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Food added"),
            @ApiResponse(responseCode = "404" , description = "Food cannot added")

    }
    )
    @PostMapping("/add")
    public ResponseEntity<Blog> add(@Valid @RequestBody BlogDTO blogDTO){
        blogServiceImpl.createBlog(blogDTO);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get Food By Id")
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Blog>> getById(@PathVariable Long id){
        Optional<Blog> blog = blogServiceImpl.getById(id);
        if(blog.isEmpty()){
            throw new RuntimeException("Error");
        }
        return ResponseEntity.ok(blog);
    }

    @Operation(summary = "Get Food By Title")
    @GetMapping("/title/{title}")
    public ResponseEntity<Optional<Blog>> getByTitle(@PathVariable String title){
        Optional<Blog> blog = blogServiceImpl.getByTitle(title);
        if(blog.isEmpty()){
            throw new RuntimeException("Error");
        }
        return ResponseEntity.ok(blog);
    }

    @Operation(summary = "Delete Food")
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Blog>> deleteById(@PathVariable Long id){
        Optional<Blog> blog = blogServiceImpl.getById(id);

        if(blog.isEmpty()){
            throw new RuntimeException("Error");
        }
        blogServiceImpl.deleteById(id);
        return ResponseEntity.ok(blog);

    }

}
