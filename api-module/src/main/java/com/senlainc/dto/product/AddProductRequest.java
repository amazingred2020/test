package com.senlainc.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class AddProductRequest {

    @NotEmpty
    private String name;

    @NotNull
    @Digits(integer = 19, fraction = 2)
    private BigDecimal price;

    @Min(1)
    private long userId;

    private String description;

    public AddProductRequest(String name, BigDecimal price, Long userId, String description) {
        this.name = name;
        this.price = price;
        this.userId = userId;
        this.description = description;
    }
}
