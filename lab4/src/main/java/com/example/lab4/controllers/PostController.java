package com.example.lab4.controllers;

import com.example.lab4.model.PostEntity;
import com.example.lab4.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public String createPost(PostEntity post, Model model) {
        postService.savePost(post);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deletePost(@RequestParam("id") Integer id, Model model) {
        postService.deleteById(id);
        return "redirect:/";
    }
}
