package com.learn.users.dto;

import lombok.*;

import java.io.Serializable;

@ToString
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserDto implements Serializable {
    private static final long serialVersionUID = -7710431516463436601L;

    private String name;
    private String gender;
    private String userId;
}
