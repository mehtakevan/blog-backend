package com.blogbackend.blog.services.impl;

import com.blogbackend.blog.entities.Comment;
import com.blogbackend.blog.entities.Post;
import com.blogbackend.blog.entities.User;
import com.blogbackend.blog.exeptions.ResourceNotFoundException;
import com.blogbackend.blog.payloads.CommentDto;
import com.blogbackend.blog.repositories.CommentRepo;
import com.blogbackend.blog.repositories.PostRepo;
import com.blogbackend.blog.repositories.UserRepo;
import com.blogbackend.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","Post Id",postId));
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User Id",userId));

        Comment comment = this.modelMapper.map(commentDto,Comment.class);

        comment.setPost(post);
        comment.setUser(user);

        Comment createdComment = this.commentRepo.save(comment);

        return this.modelMapper.map(createdComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","Comment Id",commentId));

        this.commentRepo.delete(comment);
    }
}
