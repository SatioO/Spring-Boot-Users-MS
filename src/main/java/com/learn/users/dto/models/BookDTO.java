package com.learn.users.dto.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true, fluent = true)
public class BookDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;

    @NotEmpty
    String name;

    @NotEmpty
    String description;

    @NotNull
    int price;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern="dd-MM-yyyy")
    Date publishedOn = new Date();
}
