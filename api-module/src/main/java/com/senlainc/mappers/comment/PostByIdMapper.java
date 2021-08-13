package com.senlainc.mappers.comment;

import com.senlainc.dao.PostDao;
import com.senlainc.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;

public class PostByIdMapper {

    @Autowired
    private PostDao postDao;

    public Post fromIdToPost(Long id){
        return postDao.findById(id);
    }
}
