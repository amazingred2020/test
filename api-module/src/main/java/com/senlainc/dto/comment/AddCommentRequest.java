package com.senlainc.dto.comment;

import javax.validation.constraints.NotNull;

public class AddCommentRequest {

    @NotNull
    private String content;

    @NotNull
    private Long userId;

    @NotNull
    private Long postId;

    private Long parentId;

    public AddCommentRequest(){
    }

    public String getContent() {
        return content;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getParentId() {
        return parentId;
    }
}
