package com.example.employee_assessment_system.service;

import com.example.employee_assessment_system.dto.UserRequest;
import com.example.employee_assessment_system.entity.User;

public interface UserService {
    User createUser(UserRequest request);
}