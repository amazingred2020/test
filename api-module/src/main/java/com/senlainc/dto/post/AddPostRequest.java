package com.senlainc.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class AddPostRequest {

    @NotEmpty
    private String content;

    @NotNull
    private Long userId;

    @NotNull
    private Long categoryId;
}
