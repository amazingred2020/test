package com.senlainc.dao;

import com.senlainc.entity.Comment;

public interface CommentDao {

    Comment save(Comment comment);
    Comment findById(Long id);
    void remove(Long id);
}
