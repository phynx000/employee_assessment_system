package com.example.employee_assessment_system.service;

import com.example.employee_assessment_system.dto.request.UserCreateDTO;
import com.example.employee_assessment_system.dto.response.UserDTO;
import com.example.employee_assessment_system.entity.User;
import com.example.employee_assessment_system.mapper.UserMapper;
import com.example.employee_assessment_system.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Get the currently authenticated user
     * @return current user entity
     */
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Current user not found"));
    }
    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        User user = userMapper.createUserDTOToUser(userCreateDTO);
        return userMapper.toDTO(userRepository.save(user));
    }
}