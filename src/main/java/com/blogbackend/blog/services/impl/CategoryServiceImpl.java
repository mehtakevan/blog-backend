package com.blogbackend.blog.services.impl;

import com.blogbackend.blog.entities.Category;
import com.blogbackend.blog.exeptions.ResourceNotFoundException;
import com.blogbackend.blog.payloads.CategoryDto;
import com.blogbackend.blog.repositories.CategoryRepo;
import com.blogbackend.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto creteCategory(CategoryDto categoryDto) {

        Category category = this.modelMapper.map(categoryDto,Category.class);

        Category createdCategory = this.categoryRepo.save(category);

        return this.modelMapper.map(createdCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category existCategory = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category Id",categoryId));

        existCategory.setCategoryTitle(categoryDto.getCategoryTitle());
        existCategory.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updatedCategory = this.categoryRepo.save(existCategory);
        return this.modelMapper.map(updatedCategory,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category existCategory = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));
        this.categoryRepo.delete(existCategory);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category existCategory = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category Id",categoryId));


        return this.modelMapper.map(existCategory,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = this.categoryRepo.findAll();

        List<CategoryDto> categoryDtos = categories.stream().map((cat)->this.modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos;
    }
}
