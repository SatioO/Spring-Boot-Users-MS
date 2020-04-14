package com.learn.users.dto.models;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Data
@Accessors(chain = true)
public class BundleDTO {
    private Long id;

    @NotEmpty
    private String name;
}
