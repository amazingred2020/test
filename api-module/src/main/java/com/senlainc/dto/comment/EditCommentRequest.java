package com.senlainc.dto.comment;

import javax.validation.constraints.NotNull;

public class EditCommentRequest {

    @NotNull
    private String content;

    @NotNull
    private Long commentId;

    public EditCommentRequest(){
    }

    public String getContent() {
        return content;
    }

    public Long getCommentId() {
        return commentId;
    }
}
