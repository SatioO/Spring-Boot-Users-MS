package com.learn.users.dto.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long userId;

    @NotNull
    private Long bookId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserDTO user;
}
