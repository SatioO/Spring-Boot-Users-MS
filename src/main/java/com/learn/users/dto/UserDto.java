package com.learn.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@ToString
@Getter @Setter
public class UserDto implements Serializable {

    private UUID userId;
    @NotNull
    private String name;
    @NotNull
    private String gender;
}
