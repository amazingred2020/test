package com.senlainc.dao;

import com.senlainc.entity.Post;

public interface PostDao {

    Post save(Post post);
    Post findById(Long id);
    void remove(Long id);
    Post findByContent(String content);
}
