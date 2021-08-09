package com.senlainc.dto.group;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class GroupUserRequest {

    @NotNull
    private Long groupId;

    @NotNull
    private Long userId;

    private Long fromId;

    private String buttonName;
}
