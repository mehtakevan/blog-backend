package com.blogbackend.blog.services;

import com.blogbackend.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    //Create
    CategoryDto creteCategory(CategoryDto categoryDto);

    //Update
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

    //delete
    void deleteCategory(Integer categoryId);

    //get
    CategoryDto getCategory(Integer categoryId);

    //get All
    List<CategoryDto> getAllCategory();

}
