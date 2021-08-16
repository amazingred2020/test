package com.senlainc.mappers.comment;

import com.senlainc.dao.CommentDao;
import com.senlainc.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentById {

    @Autowired
    private CommentDao commentDao;

    public Comment fromIdToComment(Long id){
        return commentDao.findById(id);
    }
}
