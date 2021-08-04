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

    @NotNull
    @Min(1)
    private Long userId;

    private String description;
}
