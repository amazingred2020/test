package com.senlainc.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class AddFriendRequest {

    @Min(1)
    private long userFrom;

    @Min(1)
    private long userTo;

    @NotEmpty
    private String buttonName;
}
