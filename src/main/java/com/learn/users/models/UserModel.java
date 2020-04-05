package com.learn.users.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
public class UserModel {
    @NotNull
    private String name;
    @NotNull
    private String gender;
}
