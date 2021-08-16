package com.senlainc.mappers.comment;

import com.senlainc.dao.PostDao;
import com.senlainc.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostById {

    @Autowired
    private PostDao postDao;

    public Post fromIdToPost(Long id){
        return postDao.findById(id);
    }
}
