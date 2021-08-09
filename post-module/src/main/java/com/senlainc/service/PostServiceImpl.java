package com.senlainc.service;

import com.senlainc.dao.CategoryDao;
import com.senlainc.dao.PostDao;
import com.senlainc.dao.UserDao;
import com.senlainc.dto.post.AddPostRequest;
import com.senlainc.dto.post.EditPostRequest;
import com.senlainc.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostServiceImpl implements PostService{

    @Autowired
    private PostDao postDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Post findPostById(Long id) {
        return postDao.findById(id);
    }

    @Override
    public void deletePost(Long id) {
        postDao.remove(id);
    }

    @Override
    public Post publishPost(AddPostRequest request) {
        Post newPost = new Post(request.getContent());
        newPost.setUser(userDao.findById(request.getUserId()));
        newPost.setCategory(categoryDao.findById(request.getCategoryId()));

        return postDao.save(newPost);
    }

    @Override
    public Post editPost(EditPostRequest request) {
        Post editPost = findPostById(request.getPostId());
        editPost.setContent(request.getContent());
        if(request.getCategoryId() != null){
            editPost.setCategory(categoryDao.findById(request.getCategoryId()));
        }

        return postDao.save(editPost);
    }
}
