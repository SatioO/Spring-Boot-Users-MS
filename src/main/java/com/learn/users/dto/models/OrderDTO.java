package com.learn.users.dto.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    private int price;

    @NotNull
    private int quantity;

    private String couponCode;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date orderedOn = new Date();

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date deliveredOn;

    @NotNull
    private Long bookId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserDTO user;
}
