package com.senlainc.controller;

import com.senlainc.dto.comment.AddCommentRequest;
import com.senlainc.dto.comment.EditCommentRequest;
import com.senlainc.entity.Comment;
import com.senlainc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/new")
    public Comment addComment(@RequestBody @Valid AddCommentRequest request, BindingResult result){
        if (!result.hasErrors()){
            return commentService.addComment(request);
        }
        return null;
    }

    @PostMapping(value = "/edit")
    public Comment editComment(@RequestBody @Valid EditCommentRequest request, BindingResult result){
        if(!result.hasErrors()){
            return commentService.editComment(request);
        }
        return null;
    }

    @GetMapping(value = "/{id}")
    public void deleteComment(@PathVariable("id") Long commentId){
        commentService.deleteComment(commentId);
    }
}
