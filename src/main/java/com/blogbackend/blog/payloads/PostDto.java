package com.blogbackend.blog.payloads;

import com.blogbackend.blog.entities.Category;
import com.blogbackend.blog.entities.Comment;
import com.blogbackend.blog.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private Integer postId;

    private String title;

    private String content;

    private Date addedDate;

    private String imageName;

    private CategoryDto category;

    private  UserDto user;

    private List<CommentDto> comments = new ArrayList<>();
}
