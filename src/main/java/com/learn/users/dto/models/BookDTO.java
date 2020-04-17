package com.learn.users.dto.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.learn.users.entities.User;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Accessors(chain = true)
public class BookDTO {
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotNull
    private int price;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date publishedOn = new Date();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Long> authorIds;

    private Set<UserDTO> authors;

    private Set<SectionDTO> sections;
}
