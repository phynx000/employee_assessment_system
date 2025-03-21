package com.example.employee_assessment_system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriteriaDTO {
    private Long id;
    private String name;
    private String description;
    private Long templateId;
}