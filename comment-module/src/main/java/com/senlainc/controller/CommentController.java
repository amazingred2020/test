package com.senlainc.controller;

import com.senlainc.dto.comment.SaveCommentRequest;
import com.senlainc.dto.comment.UpdateCommentRequest;
import com.senlainc.entity.Comment;
import com.senlainc.routes.CommentRoutes;
import com.senlainc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(CommentRoutes.COMMENT)
    public Comment addComment(@RequestBody @Validated SaveCommentRequest request){
        return commentService.addComment(request);
    }

    @PutMapping(CommentRoutes.COMMENT)
    public Comment editComment(@RequestBody @Validated UpdateCommentRequest request){
        return commentService.editComment(request);
    }

    @DeleteMapping(CommentRoutes.COMMENT_BY_ID)
    public void deleteComment(@PathVariable("id") Long commentId){
        commentService.deleteComment(commentId);
    }

    @GetMapping(CommentRoutes.COMMENT_BY_ID)
    public List<Comment> getCommentsByPostId(@PathVariable long id){
        return commentService.getCommentsByPostId(id);
    }
}
