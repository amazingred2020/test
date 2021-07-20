package com.senlainc.service;

import com.senlainc.entity.Post;

public interface PostService {

    Post savePost(Post post);
    Post findPostById(Long id);
    void deletePost(Long id);
}
