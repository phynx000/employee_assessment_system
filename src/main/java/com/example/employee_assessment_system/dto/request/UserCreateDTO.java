package com.example.employee_assessment_system.dto.request;

import com.example.employee_assessment_system.entity.User;

public class UserCreateDTO {
    private String username;
    private String password;
    private String fullname;
    private User.Role role;
}
