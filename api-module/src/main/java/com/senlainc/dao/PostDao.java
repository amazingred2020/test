package com.senlainc.dao;

import com.senlainc.entity.Post;

import java.util.List;

public interface PostDao {

    Post save(Post post);
    Post findById(Long id);
    void remove(Long id);
    Post findByContent(String content);
    List<Post> getPostsByProfileId(long profileId);
    List<Post> getPostsByGroupId(long groupId);
}
