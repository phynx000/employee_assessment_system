package com.example.employee_assessment_system.service;

import com.example.employee_assessment_system.dto.ApiResponse;
import com.example.employee_assessment_system.entity.User;
import com.example.employee_assessment_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    UserRepository userRepository;

    public ApiResponse deleteEmployee(long id) {
        User user = userRepository.findById(id)
                .orElse(null);

        if (user == null) {
            return new ApiResponse(true, "Employee not found", null);
        }

        if (user.getRole() != User.Role.EMPLOYEE) {
            return new ApiResponse(true, "User is not employee", null);
        }

        user.setActive(false);
        userRepository.save(user);

        return new ApiResponse(false, "Deleted successfully", null);
    }
}
