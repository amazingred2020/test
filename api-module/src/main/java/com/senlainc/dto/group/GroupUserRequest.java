package com.senlainc.dto.group;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class GroupUserRequest {

    @NotNull
    private Long groupId;

    @NotNull
    private Long userId;

    private Long fromId;

    private String buttonName;
}
