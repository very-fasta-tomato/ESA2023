package com.example.lab3.restController;

import com.example.lab3.model.PostEntity;
import com.example.lab3.services.PostService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(
        value = "api/post",
        produces = {"application/xml", "application/json"}
)
public class PostRestController {
    @Autowired
    private PostService postService;

    @GetMapping
    public @ResponseBody Iterable<PostEntity> getPosts() {
        return postService.getAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody PostEntity getPost(@PathVariable Integer id) {
        return postService.getPostById(id);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody void deletePost(@PathVariable Integer id) {
        postService.deleteById(id);
    }

    @PostMapping
    public @ResponseBody int createPost(@RequestBody PostEntity post) {
        postService.savePost(post);
        return Response.SC_OK;
    }
    @PutMapping("/{id}")
    public @ResponseBody int updatePost(@PathVariable Integer id, @RequestBody PostEntity post) {
        if (postService.getPostById(id) != null) {
            var p = postService.getPostById(id);
            p.setContent(post.getContent());
            p.setTitle(post.getTitle());
            p.setContent(post.getContent());
            p.setUser_id(post.getUser_id());
            return Response.SC_OK;
        }
        return Response.SC_NOT_FOUND;
    }
}

