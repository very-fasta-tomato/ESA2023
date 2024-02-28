package com.example.lab4.restController;

import com.example.lab4.jms.Sender;
import com.example.lab4.model.EventType;
import com.example.lab4.model.Model;
import com.example.lab4.model.PostEntity;
import com.example.lab4.model.UserEntity;
import com.example.lab4.services.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(
        value = "api/user",
        produces = {"application/xml", "application/json"}
)
public class UserRestController {
    @Autowired
    private UserService userService;

    @Autowired
    private Sender sender;

    @GetMapping
    public @ResponseBody Iterable<UserEntity> getPosts() {
        return userService.getAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody UserEntity getPost(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody int deleteUser(@PathVariable Integer id) {
        if (userService.getUserById(id) != null) {
            var p = userService.getUserById(id);
            sender.sendEvent(p, EventType.DELETE, Model.USER, p.getId());
            userService.deleteById(id);
            return Response.SC_OK;
        }
        return Response.SC_NOT_FOUND;
    }

    @PostMapping
    public @ResponseBody int createUser(@RequestBody UserEntity user) {
        var u = userService.saveUser(user);
        sender.sendEvent(u, EventType.CREATE, Model.USER, u.getId());
        return Response.SC_OK;
    }

    @PutMapping("{id}")
    public @ResponseBody int updateUser(@PathVariable Integer id, @RequestBody UserEntity user) {
        if (userService.getUserById(id) != null) {
            var p = userService.getUserById(id);
            p.setUsername(user.getUsername());

            sender.sendEvent(p, EventType.UPDATE, Model.USER, p.getId());
            return Response.SC_OK;
        }
        return Response.SC_NOT_FOUND;
    }
}

