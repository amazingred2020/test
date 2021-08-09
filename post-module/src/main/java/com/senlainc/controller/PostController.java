package com.senlainc.controller;

import com.senlainc.dto.post.AddPostRequest;
import com.senlainc.dto.post.EditPostRequest;
import com.senlainc.entity.Post;
import com.senlainc.routes.PostRoutes;
import com.senlainc.service.CategoryService;
import com.senlainc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping(PostRoutes.POST)
    public Post newPost(@RequestBody @Validated AddPostRequest request){
        return postService.publishPost(request);
    }

    @DeleteMapping(PostRoutes.DELETE_POST)
    public void deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
    }

    @PutMapping(PostRoutes.UPDATE_POST)
    public Post editPost(@RequestBody @Validated EditPostRequest request){
        return postService.editPost(request);
    }

    @GetMapping(PostRoutes.POST_CATEGORY)
    public void newCategory(@RequestParam String name, @RequestParam(required = false) Long parentId){
        categoryService.createCategory(name, parentId);
    }

    @DeleteMapping(PostRoutes.DELETE_POST_CATEGORY)
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
