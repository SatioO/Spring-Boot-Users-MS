package com.learn.users.dto.models;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Data
@Accessors(chain = true)
public class TemplateDTO {
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String content;


}
