package com.senlainc.dao;

import com.senlainc.entity.Comment;

import java.util.List;

public interface CommentDao {

    Comment save(Comment comment);
    Comment findById(Long id);
    void remove(Long id);
    List<Comment> getCommentsByPostId(long id);
}
