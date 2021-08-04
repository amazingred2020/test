package com.senlainc.service;

import com.senlainc.dto.comment.AddCommentRequest;
import com.senlainc.dto.comment.EditCommentRequest;
import com.senlainc.entity.Comment;

public interface CommentService {

    void deleteComment(Long id);
    Comment addComment(AddCommentRequest request);
    Comment editComment(EditCommentRequest request);
}
