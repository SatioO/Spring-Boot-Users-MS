package com.learn.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@ToString
@Getter @Setter
public class UserDto implements Serializable {
    private static final long serialVersionUID = -7710431516463436601L;

    private UUID userId;
    private String name;
    private String gender;
}
