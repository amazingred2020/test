package com.senlainc.dto.invite;

import com.senlainc.enums.EnumNamePattern;
import com.senlainc.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
public class SaveGroupInviteRequest {

    @Min(1)
    private long userFrom;

    @Min(1)
    private long userTo;

    @Min(1)
    private long groupId;

    @EnumNamePattern(regexp = "WAIT")
    private Status status;
}