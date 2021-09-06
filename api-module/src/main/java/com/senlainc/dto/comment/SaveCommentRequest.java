package com.senlainc.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class SaveCommentRequest {

    @NotEmpty
    private String content;

    @Min(1)
    private long userId;

    @Min(1)
    private long postId;
}
