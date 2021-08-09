package com.senlainc.unit.post;

import com.senlainc.dao.PostDao;
import com.senlainc.dto.post.AddPostRequest;
import com.senlainc.dto.post.EditPostRequest;
import com.senlainc.entity.Post;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.PostService;
import com.senlainc.testconfig.TestConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ContextConfiguration(classes = {JpaConfiguration.class, TestConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostDao postDao;

    @Test
    public void testFindPostById(){
        Long id = 1l;
        Post post = postService.findPostById(id);

        Assert.assertNotNull(post);
    }

    @Test
    public void testDeletePost(){
        Long id = 1l;
        postService.deletePost(id);
        Post post = postService.findPostById(id);

        Assert.assertNull(post);
    }

    @Test
    public void testPublishPost(){
        AddPostRequest request = new AddPostRequest();
        request.setContent("new post content");
        request.setUserId(1l);
        request.setCategoryId(1l);
        postService.publishPost(request);
        Post post = postDao.findByContent("new post content");

        Assert.assertFalse("some content".equals(post.getContent()));
    }

    @Test
    public void testEditPost(){
        EditPostRequest request = new EditPostRequest();
        request.setPostId(1l);
        request.setContent("new post text");
        request.setCategoryId(2l);
        postService.editPost(request);
        Post post = postDao.findByContent("new post text");

        Assert.assertEquals(Long.valueOf(2), post.getCategory().getId());
    }
}
