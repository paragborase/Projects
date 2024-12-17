package com.security.springsecurity.controller;

import com.security.springsecurity.model.Users;
import com.security.springsecurity.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users users) {
        return userService.register(users);
    }

    @PostMapping("/login_user")
    public String login(@RequestBody Users users) {
        System.out.println(users);
        return userService.verify(users);
    }
}
