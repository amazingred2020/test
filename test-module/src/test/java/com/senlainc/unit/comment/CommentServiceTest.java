package com.senlainc.unit.comment;

import com.senlainc.TestConfiguration;
import com.senlainc.dao.CommentDao;
import com.senlainc.dto.comment.SaveCommentRequest;
import com.senlainc.dto.comment.UpdateCommentRequest;
import com.senlainc.entity.Comment;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.CommentService;
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
public class CommentServiceTest{

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentDao commentDao;

    @Test
    public void testDeleteComment(){
        Long id = 1l;
        commentService.deleteComment(id);

        Assert.assertNull(commentDao.findById(1l));
    }

    @Test
    public void testAddComment(){
        SaveCommentRequest request = new SaveCommentRequest();
        request.setContent("comment text");
        request.setPostId(2l);
        request.setUserId(1l);
        Comment comment = commentService.addComment(request);

        Assert.assertNotEquals(Long.valueOf(3), comment.getPost().getId());
    }

    @Test
    public void testEditComment(){
        UpdateCommentRequest request = new UpdateCommentRequest();
        request.setContent("text has been changed");
        request.setCommentId(1l);
        commentService.editComment(request);
        String content = commentDao.findById(1l).getContent();

        Assert.assertEquals("not equals!", "text has been changed", content);
    }
}