package com.example.lab3.controllers;

import com.example.lab3.services.PostService;
import com.example.lab3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String greeting(Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("posts", postService.getAll());
        return "main";
    }
}
