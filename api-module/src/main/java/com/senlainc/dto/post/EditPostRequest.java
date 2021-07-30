package com.senlainc.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class EditPostRequest {

    @NotNull
    private Long postId;
    @NotEmpty
    private String content;

    private Long categoryId;
}