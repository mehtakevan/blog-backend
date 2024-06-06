package com.blogbackend.blog.payloads;


import com.blogbackend.blog.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private Integer commentId;

    private String content;

    private UserDto user;

}