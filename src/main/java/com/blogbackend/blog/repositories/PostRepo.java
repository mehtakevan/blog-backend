package com.blogbackend.blog.repositories;

import com.blogbackend.blog.entities.Category;
import com.blogbackend.blog.entities.Post;
import com.blogbackend.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findAllByUser(User user);
    List<Post> findAllByCategory(Category category);
    List<Post> findByTitleContaining(String title);
}
