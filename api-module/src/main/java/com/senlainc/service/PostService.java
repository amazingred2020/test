package com.senlainc.service;

import com.senlainc.dto.post.SavePostRequest;
import com.senlainc.dto.post.UpdatePostRequest;
import com.senlainc.entity.Post;

import java.util.List;

public interface PostService {

    Post findPostById(Long id);
    void deletePost(Long id);
    Post publishPost(SavePostRequest request);
    Post editPost(UpdatePostRequest request);
    List<Post> getPostsByProfile(long profileId);
    List<Post> getPostsByGroupId(long groupId);
}
