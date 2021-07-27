package com.senlainc.dto.group;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewGroupRequest {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private Long userId;

    private String description;

    public NewGroupRequest(){
    }

    public String getName() {
        return name;
    }

    public Long getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }
}
