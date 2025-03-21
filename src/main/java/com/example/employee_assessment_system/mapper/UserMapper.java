package com.example.employee_assessment_system.mapper;

import com.example.employee_assessment_system.dto.request.UserCreateDTO;
import com.example.employee_assessment_system.dto.response.UserDTO;
import com.example.employee_assessment_system.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "password", ignore = true) // Don't expose password in DTOs
    UserDTO toDTO(User user);

    @Mapping(target = "id", ignore = true)
    User createUserDTOToUser(UserCreateDTO userDTO);

    List<UserDTO> toDTOList(List<User> users);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true) // Handle password separately with encoding
    User toEntity(UserDTO userDTO);
}