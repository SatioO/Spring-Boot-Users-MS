package com.learn.users.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class UserDto implements Serializable {
    private static final long serialVersionUID = -7710431516463436601L;

    private String name;
    private String gender;
    private String userId;
}
