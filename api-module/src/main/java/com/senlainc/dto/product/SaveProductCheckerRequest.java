package com.senlainc.dto.product;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
public class SaveProductCheckerRequest {

    @NotEmpty
    private String name;

    @NotNull
    @Digits(integer = 19, fraction = 2)
    private BigDecimal price;

    private String description;

    @Min(1)
    private long productId;
}
