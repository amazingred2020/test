package com.senlainc.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class EditCommentRequest {

    @NotEmpty
    private String content;

    @NotNull
    private Long commentId;
}
