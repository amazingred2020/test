package com.senlainc.service;

import com.senlainc.dao.CommentDao;
import com.senlainc.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Comment saveComment(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public Comment publishComment(Comment comment, Long userId, Long postId) {
        return commentDao.publishComment(comment, userId, postId);
    }

    @Override
    public Comment editComment(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentDao.remove(id);
    }
}