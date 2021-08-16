package com.senlainc.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class SaveProductRequest {

    @NotEmpty
    private String name;

    @NotNull
    @Digits(integer = 19, fraction = 2)
    private BigDecimal price;

    @Min(1)
    private long userId;

    private String description;
}
