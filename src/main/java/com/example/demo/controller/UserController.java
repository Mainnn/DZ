package com.example.demo.controller;

import com.example.demo.DTO.UserDto;
import com.example.demo.service.imp.serviceInterface.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("")
public class UserController {

    private final UserServiceImp userServiceImp;

    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @RequestMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createUser(@RequestBody UserDto user) {
        return userServiceImp.create(user);
    }
}
