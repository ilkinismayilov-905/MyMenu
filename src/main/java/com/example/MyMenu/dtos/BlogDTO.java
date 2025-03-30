package com.example.MyMenu.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {

    private String title;
    private String description;
    private List<Long> imageIds;
}
