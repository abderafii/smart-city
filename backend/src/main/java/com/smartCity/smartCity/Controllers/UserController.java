package com.smartCity.smartCity.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartCity.smartCity.Entities.User;
import com.smartCity.smartCity.Services.UserService;


@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    private UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers() {
        return "Hello, World!";
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
}
