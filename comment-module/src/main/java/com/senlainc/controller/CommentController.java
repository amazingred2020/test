package com.senlainc.controller;

import com.senlainc.dto.comment.AddCommentRequest;
import com.senlainc.dto.comment.EditCommentRequest;
import com.senlainc.entity.Comment;
import com.senlainc.routes.CommentRoutes;
import com.senlainc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(CommentRoutes.COMMENT)
    public Comment addComment(@RequestBody @Validated AddCommentRequest request){
        return commentService.addComment(request);
    }

    @PutMapping(CommentRoutes.UPDATE_COMMENT)
    public Comment editComment(@RequestBody @Validated EditCommentRequest request){
        return commentService.editComment(request);
    }

    @DeleteMapping(CommentRoutes.DELETE_COMMENT)
    public void deleteComment(@PathVariable("id") Long commentId){
        commentService.deleteComment(commentId);
    }
}
