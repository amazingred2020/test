package com.senlainc.dto.post;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddPostRequest {

    @NotNull
    @NotBlank
    private String content;

    @NotNull
    @NotBlank
    private Long userId;

    @NotNull
    @NotBlank
    private Long categoryId;

    public AddPostRequest(){
    }

    public String getContent() {
        return content;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
