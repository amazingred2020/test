package com.senlainc.service;

import com.senlainc.dto.comment.SaveCommentRequest;
import com.senlainc.dto.comment.UpdateCommentRequest;
import com.senlainc.entity.Comment;

import java.util.List;

public interface CommentService {

    void deleteComment(Long id);
    Comment addComment(SaveCommentRequest request);
    Comment editComment(UpdateCommentRequest request);
    List<Comment> getCommentsByPostId(long id);
}
