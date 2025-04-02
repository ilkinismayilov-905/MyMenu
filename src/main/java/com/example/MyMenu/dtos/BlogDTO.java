package com.example.MyMenu.dtos;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor

public class BlogDTO {

    private String title;
    private String description;
    private List<Long> imageIds;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getImageIds() {
        return imageIds;
    }

    public void setImageIds(List<Long> imageIds) {
        this.imageIds = imageIds;
    }
}
