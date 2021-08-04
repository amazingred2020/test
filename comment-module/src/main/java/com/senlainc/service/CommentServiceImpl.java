package com.senlainc.service;

import com.senlainc.dao.CommentDao;
import com.senlainc.dao.PostDao;
import com.senlainc.dao.UserDao;
import com.senlainc.dto.comment.AddCommentRequest;
import com.senlainc.dto.comment.EditCommentRequest;
import com.senlainc.entity.Comment;
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

    @Override
    public void deleteComment(Long id) {
        commentDao.remove(id);
    }

    @Override
    public Comment addComment(AddCommentRequest request) {
        Comment newComment = new Comment(request.getContent());
        newComment.setUser(userDao.findById(request.getUserId()));
        newComment.setPost(postDao.findById(request.getPostId()));
        if(request.getParentId() != null){
            newComment.setParent(commentDao.findById(request.getParentId()));
        }
        return commentDao.save(newComment);
    }

    @Override
    public Comment editComment(EditCommentRequest request) {
        Comment editComment = commentDao.findById(request.getCommentId());
        editComment.setContent(request.getContent());
        return commentDao.save(editComment);
    }
}
