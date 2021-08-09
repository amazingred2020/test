package com.senlainc.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AddPostRequest {

    @NotEmpty
    private String content;

    @NotNull
    private Long userId;

    @NotNull
    private Long categoryId;
}
