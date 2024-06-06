package com.blogbackend.blog.services;

import com.blogbackend.blog.payloads.CommentDto;

public interface CommentService{

    CommentDto createComment(CommentDto commentDto,Integer postId,Integer userId);

    void deleteComment(Integer commentId);

}
