package com.senlainc.service;

import com.senlainc.dto.comment.SaveCommentRequest;
import com.senlainc.dto.comment.UpdateCommentRequest;
import com.senlainc.entity.Comment;

public interface CommentService {

    void deleteComment(Long id);
    Comment addComment(SaveCommentRequest request);
    Comment editComment(UpdateCommentRequest request);
}
