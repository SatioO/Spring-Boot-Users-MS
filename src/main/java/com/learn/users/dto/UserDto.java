package com.learn.users.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter @Setter
public class UserDto implements Serializable {
    private static final long serialversionUID = 129348938L;

    @NotNull
    private String name;
    @NotNull
    private String gender;
}
