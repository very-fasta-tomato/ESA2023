package com.example.lab3.restController;

import com.example.lab3.model.UserEntity;
import com.example.lab3.services.UserService;
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

    @GetMapping
    public @ResponseBody Iterable<UserEntity> getPosts() {
        return userService.getAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody UserEntity getPost(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @PostMapping
    public @ResponseBody int createUser(@RequestBody UserEntity user) {
        userService.saveUser(user);
        return Response.SC_OK;
    }
    @PutMapping("{id}")
    public @ResponseBody int updateUser(@PathVariable Integer id, @RequestBody UserEntity user) {
        if (userService.getUserById(id) != null) {
            var p = userService.getUserById(id);
            p.setUsername(user.getUsername());
            return Response.SC_OK;
        }
        return Response.SC_NOT_FOUND;
    }
}

