package com.senlainc.service;

import com.senlainc.entity.Comment;

public interface CommentService {

    Comment saveComment(Comment comment);
    Comment publishComment(Comment comment, Long userId, Long postId);
    Comment editComment(Comment comment);
    void deleteComment(Long id);
}
