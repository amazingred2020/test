package com.senlainc.service;

import com.senlainc.dto.post.SavePostRequest;
import com.senlainc.dto.post.UpdatePostRequest;
import com.senlainc.entity.Post;

public interface PostService {

    Post findPostById(Long id);
    void deletePost(Long id);
    Post publishPost(SavePostRequest request);
    Post editPost(UpdatePostRequest request);
}
