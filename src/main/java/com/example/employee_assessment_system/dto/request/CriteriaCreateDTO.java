package com.example.employee_assessment_system.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriteriaCreateDTO {
    private String name;
    private String description;
    private Long templateId;
}