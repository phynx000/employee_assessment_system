package com.example.employee_assessment_system.security;

import com.example.employee_assessment_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class UserSecurity {

    private final UserService userService;

    @Autowired
    public UserSecurity(UserService userService) {
        this.userService = userService;
    }

    /**
     * Check if the current user is the same as the requested user
     * Used for method security expressions
     */
    public boolean isSameUser(Long userId) {
        return userService.getCurrentUser().getId().equals(userId);
    }
}
