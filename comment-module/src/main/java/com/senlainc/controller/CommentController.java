package com.senlainc.controller;

import com.senlainc.dto.comment.AddCommentRequest;
import com.senlainc.dto.comment.EditCommentRequest;
import com.senlainc.entity.Comment;
import com.senlainc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/new")
    public Comment addComment(@RequestBody @Validated AddCommentRequest request){
        return commentService.addComment(request);
    }

    @PostMapping(value = "/edit")
    public Comment editComment(@RequestBody @Validated EditCommentRequest request){
        return commentService.editComment(request);
    }

    @GetMapping(value = "/{id}")
    public void deleteComment(@PathVariable("id") Long commentId){
        commentService.deleteComment(commentId);
    }
}
