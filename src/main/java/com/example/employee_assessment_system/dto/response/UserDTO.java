package com.example.employee_assessment_system.dto.response;

import com.example.employee_assessment_system.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String fullname;
    private User.Role role = User.Role.EMPLOYEE;
    private boolean isActive;

}
