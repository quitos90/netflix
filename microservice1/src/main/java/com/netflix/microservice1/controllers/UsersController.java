package com.netflix.microservice1.controllers;

import com.netflix.common.model.User;
import com.netflix.microservice1.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersServices usersServices;
    @GetMapping
    private List<User> getUsers(){
        return usersServices.getAllUsers();
    }

    @PostMapping
    private User insertUser(@RequestBody User user){
        return usersServices.saveUser(user);
    }
}
