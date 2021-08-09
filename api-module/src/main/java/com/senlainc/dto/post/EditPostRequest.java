package com.senlainc.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class EditPostRequest {

    @NotNull
    private Long postId;
    @NotEmpty
    private String content;

    private Long categoryId;
}
