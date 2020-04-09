package com.learn.users.dto.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String userId;
}
