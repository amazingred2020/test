package com.senlainc.service;

import com.senlainc.dto.post.AddPostRequest;
import com.senlainc.dto.post.EditPostRequest;
import com.senlainc.entity.Post;

public interface PostService {

    Post findPostById(Long id);
    void deletePost(Long id);
    Post publishPost(AddPostRequest request);
    Post editPost(EditPostRequest request);
}
