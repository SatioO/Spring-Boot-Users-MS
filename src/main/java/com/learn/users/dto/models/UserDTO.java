package com.learn.users.dto.models;

import com.learn.users.enums.GenderType;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true, fluent = true)
public class UserDTO {
    private Long id;

    @NotEmpty(message = "First name must not be empty")
    private String firstName;

    @NotEmpty(message = "Last name must not be empty")
    private String lastName;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be a valid email address")
    private String email;

    @NotNull
    private GenderType gender;
}
