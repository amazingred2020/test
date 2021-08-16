package com.senlainc.service;

import com.senlainc.dao.CommentDao;
import com.senlainc.dao.PostDao;
import com.senlainc.dao.UserDao;
import com.senlainc.dto.comment.SaveCommentRequest;
import com.senlainc.dto.comment.UpdateCommentRequest;
import com.senlainc.entity.Comment;
import com.senlainc.mappers.comment.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentMapper сommentMapper;

    @Override
    public void deleteComment(Long id) {
        commentDao.remove(id);
    }

    @Override
    public Comment addComment(SaveCommentRequest request) {
        Comment newComment = сommentMapper.fromSaveCommentRequestToComment(request);
        return commentDao.save(newComment);
    }

    @Override
    public Comment editComment(UpdateCommentRequest request) {
        Comment editComment = commentDao.findById(request.getCommentId());
        editComment.setContent(request.getContent());
        return commentDao.save(editComment);
    }
}
