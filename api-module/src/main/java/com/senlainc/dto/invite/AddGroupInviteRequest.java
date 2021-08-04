package com.senlainc.dto.invite;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class AddGroupInviteRequest {

    @NotNull
    private Long userFrom;

    @NotNull
    private Long userTo;

    @NotNull
    private Long groupId;
}
