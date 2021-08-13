package com.senlainc.dto.group;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class SaveGroupRequest {

    @NotEmpty
    private String name;

    @Min(1)
    private long userId;

    private String description;
}
