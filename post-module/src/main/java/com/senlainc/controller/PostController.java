package com.senlainc.controller;

import com.senlainc.entity.Category;
import com.senlainc.entity.Post;
import com.senlainc.entity.User;
import com.senlainc.service.CategoryService;
import com.senlainc.service.PostService;
import com.senlainc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "/new/{userid}/{categoryid}")
    public void publishPost(@RequestBody Post post, @PathVariable Long userid, @PathVariable Long categoryid){
        User author = userService.findUserById(userid);
        Category category = categoryService.findCategoryById(categoryid);
        post.setAuthor(author);
        post.setCategory(category);
        postService.savePost(post);
    }

    @GetMapping(value = "/delete/{postid}")
    public void deletePost(@PathVariable Long postid){
        postService.deletePost(postid);
    }
}
