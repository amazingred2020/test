package com.senlainc.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AddCommentRequest {

    @NotEmpty
    private String content;

    @NotNull
    private Long userId;

    @NotNull
    private Long postId;

    private Long parentId;
}
