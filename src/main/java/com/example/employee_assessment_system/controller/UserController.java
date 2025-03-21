package com.example.employee_assessment_system.controller;

import com.example.employee_assessment_system.dto.UserRequest;
import com.example.employee_assessment_system.entity.User;
import com.example.employee_assessment_system.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody UserRequest request) {
        User createdUser = userService.createUser(request);
        return ResponseEntity.ok(createdUser);
    }
}