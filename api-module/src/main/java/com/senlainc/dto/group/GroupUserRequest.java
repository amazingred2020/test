package com.senlainc.dto.group;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
public class GroupUserRequest {

    @Min(1)
    private long groupId;

    @Min(1)
    private long userId;

    private long fromId;

    private String buttonName;
}
