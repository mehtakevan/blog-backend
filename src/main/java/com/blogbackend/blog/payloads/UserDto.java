package com.blogbackend.blog.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;

    @NotEmpty
    private String name;

    @Email(message = "Email address is invalid")
    private String email;

    @NotEmpty
    @Size(min = 3,message = "Password must be min of 3 characters")
    private String password;

    @NotNull
    private String about;
}
