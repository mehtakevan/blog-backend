package com.blogbackend.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;
    @NotBlank(message = "Title cannot be blank")
    private String categoryTitle;
    @NotBlank(message = "Description cannot be blank")
    private String categoryDescription;
}
