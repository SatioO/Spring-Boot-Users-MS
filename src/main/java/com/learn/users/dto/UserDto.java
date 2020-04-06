package com.learn.users.dto;

import lombok.*;
import javax.validation.constraints.NotNull;

@ToString
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserDto {
    @NotNull
    private String name;
    @NotNull
    private String gender;
    private String userId;
}
