package com.learn.users.dto.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@ToString
@Getter @Setter @Accessors(chain = true)
@AllArgsConstructor @NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO {
    private String bookId;

    @NotNull
    private String name;

    @NotNull
    private String userId;
}
