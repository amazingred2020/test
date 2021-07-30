package com.senlainc.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class EditCommentRequest {

    @NotEmpty
    private String content;

    @NotNull
    private Long commentId;
}
