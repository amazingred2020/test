package com.senlainc.dto.post;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EditPostRequest {

    @NotNull
    @NotBlank
    private Long postId;

    private String content;

    private Long categoryId;

    public EditPostRequest(){
    }

    public String getContent() {
        return content;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
