package com.senlainc.dto.product;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class AddProductRequest {

    @NotEmpty
    private String name;

    @NotNull
    @Digits(integer = 19, fraction = 2)
    private BigDecimal price;

    @Min(1)
    private long userId;

    private String description;

    public AddProductRequest(){
    }

    public String getName() {
        return name;
    }

    public Long getUserId() {
        return userId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
