package com.example.employee_assessment_system.service;

import com.example.employee_assessment_system.dto.UserRequest;
import com.example.employee_assessment_system.entity.User;
import com.example.employee_assessment_system.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .fullname(request.getFullname())
                .role(request.getRole() != null ? request.getRole() : User.Role.EMPLOYEE)
                .isActive(true)
                .build();
        return userRepository.save(user);
    }
}