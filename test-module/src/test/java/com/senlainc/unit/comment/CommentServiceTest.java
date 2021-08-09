package com.senlainc.unit.comment;

import com.senlainc.dao.CommentDao;
import com.senlainc.dto.comment.AddCommentRequest;
import com.senlainc.dto.comment.EditCommentRequest;
import com.senlainc.entity.Comment;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.CommentService;
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
        AddCommentRequest request = new AddCommentRequest();
        request.setContent("comment text");
        request.setPostId(1l);
        request.setUserId(1l);
        Comment comment = commentService.addComment(request);

        Assert.assertNotEquals(Long.valueOf(2), comment.getPost().getId());
    }

    @Test
    public void testEditComment(){
        EditCommentRequest request = new EditCommentRequest();
        request.setContent("text has been changed");
        request.setCommentId(1l);
        commentService.editComment(request);
        String content = commentDao.findById(1l).getContent();

        Assert.assertEquals("not equals!", "text has been changed", content);
    }
}