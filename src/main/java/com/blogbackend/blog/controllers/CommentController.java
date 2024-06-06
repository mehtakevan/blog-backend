package com.blogbackend.blog.controllers;

import com.blogbackend.blog.entities.Comment;
import com.blogbackend.blog.payloads.ApiResponse;
import com.blogbackend.blog.payloads.CommentDto;
import com.blogbackend.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{postId}/{userId}")
    public ResponseEntity<CommentDto> create(@RequestBody CommentDto commentDto, @PathVariable Integer postId,@PathVariable Integer userId){
        CommentDto savedcomment = this.commentService.createComment(commentDto,postId,userId);
        return new ResponseEntity<CommentDto>(savedcomment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{commentId}")
    public  ResponseEntity<ApiResponse>deletecomment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
        ApiResponse apiResponse = new ApiResponse("Comment deleted successfully",true);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
    }

}
