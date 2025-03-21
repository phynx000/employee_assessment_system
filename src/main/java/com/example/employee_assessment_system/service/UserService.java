package com.example.employee_assessment_system.service;

import com.example.employee_assessment_system.dto.ApiResponse;
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

import java.util.List;
import java.util.stream.Collectors;

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

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findByIsActiveTrue();
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return userMapper.toDTO(user);
    }

    public UserDTO updateUser(Long id, UserCreateDTO userUpdateDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        // Check if username is being changed and if it already exists
        if (!existingUser.getUsername().equals(userUpdateDTO.getUsername()) &&
                userRepository.findByUsername(userUpdateDTO.getUsername()).isPresent()) {
            throw new EntityNotFoundException("Username already exists");
        }

        // Map update DTO to existing user
        existingUser = userMapper.createUserDTOToUser(userUpdateDTO);

        return userMapper.toDTO(userRepository.save(existingUser));
    }

    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        if (userRepository.findByUsername(userCreateDTO.getUsername()).isPresent()) throw new EntityNotFoundException("Username already exists");
        User user = userMapper.createUserDTOToUser(userCreateDTO);
        user.setActive(true);
        return userMapper.toDTO(userRepository.save(user));
    }
    public ApiResponse deleteUser(Long id) {
        userRepository.deleteById(id);
        return new ApiResponse(false,"Deleted user successfully",null);
    }
}