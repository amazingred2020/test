package com.senlainc.dto.invite;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AddGroupInviteRequest {

    @NotNull
    private Long userFrom;

    @NotNull
    private Long userTo;

    @NotNull
    private Long groupId;
}