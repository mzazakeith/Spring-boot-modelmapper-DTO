package com.example.springboot.controller;

import com.example.springboot.dto.UserLocationDTO;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user-location")
    public List<UserLocationDTO> getAllUsersLocation(){
        return userService.getAllUsersLocation();
    }
}
