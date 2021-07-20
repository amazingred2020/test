package com.senlainc.dao;

import com.senlainc.entity.Comment;

public interface CommentDao {

    Comment save(Comment comment);
    Comment publishComment(Comment comment, Long userId, Long postId);
    void remove(Long id);
}
