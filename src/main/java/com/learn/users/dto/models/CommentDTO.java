package com.learn.users.dto.models;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class CommentDTO {
    @NotNull
    private String text;

    private PostDTO post;
}
