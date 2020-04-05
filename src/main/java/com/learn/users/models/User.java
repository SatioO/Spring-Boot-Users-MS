package com.learn.users.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter @Setter
public class User {
    @NotNull
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String gender;

    public User(UUID id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}
