package com.example.employee_assessment_system.dto;
import lombok.*;
import com.example.employee_assessment_system.entity.User.Role;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String username;
    private String password;
    private String fullname;
    private Role role;
}

