package com.learn.users.dto.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.learn.users.enums.RoleType;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true, fluent = true)
public class RoleDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    private RoleType role;
}
