package com.senlainc.dto.post;

import com.senlainc.enums.EnumNamePattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class SavePostRequest {

    @NotEmpty
    private String content;

    @Min(1)
    private long userId;

    @Min(1)
    private long categoryId;

    private long profileId;

    private long groupId;
}
