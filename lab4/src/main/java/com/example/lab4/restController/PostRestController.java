package com.example.lab4.restController;

import com.example.lab4.jms.Sender;
import com.example.lab4.model.EventType;
import com.example.lab4.model.Model;
import com.example.lab4.model.PostEntity;
import com.example.lab4.services.PostService;
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
    @Autowired
    private Sender sender;


    @GetMapping
    public @ResponseBody Iterable<PostEntity> getPosts() {
        return postService.getAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody PostEntity getPost(@PathVariable Integer id) {
        return postService.getPostById(id);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody int deletePost(@PathVariable Integer id) {
        if (postService.getPostById(id) != null) {
            var p = postService.getPostById(id);
            sender.sendEvent(p, EventType.DELETE, Model.POST, p.getId());
            postService.deleteById(id);
            return Response.SC_OK;
        }
        return Response.SC_NOT_FOUND;
    }

    @PostMapping
    public @ResponseBody int createPost(@RequestBody PostEntity post) {
        var p = postService.savePost(post);
        sender.sendEvent(p, EventType.CREATE, Model.POST, p.getId());
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
            sender.sendEvent(p, EventType.UPDATE, Model.POST, p.getId());
            return Response.SC_OK;
        }
        return Response.SC_NOT_FOUND;
    }
}

