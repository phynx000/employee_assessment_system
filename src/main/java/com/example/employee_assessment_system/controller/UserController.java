package com.example.employee_assessment_system.controller;

import com.example.employee_assessment_system.dto.ApiResponse;
import com.example.employee_assessment_system.dto.UserRequest;
import com.example.employee_assessment_system.dto.request.UserCreateDTO;
import com.example.employee_assessment_system.dto.response.UserDTO;
import com.example.employee_assessment_system.entity.User;
import com.example.employee_assessment_system.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserCreateDTO request) {
        UserDTO updatedUser = userService.updateUser(id, request);
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreateDTO request) {
        UserDTO createdUser = userService.createUser(request);
        return ResponseEntity.ok(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<ApiResponse>(userService.deleteUser(id), HttpStatus.OK);
    }

}