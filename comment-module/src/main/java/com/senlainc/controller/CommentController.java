package com.senlainc.controller;

import com.senlainc.entity.Comment;
import com.senlainc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /*@PostMapping(value = "/value")
    public void publishComment(@RequestBody Comment comment, )*/
}
