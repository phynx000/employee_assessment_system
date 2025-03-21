package com.example.employee_assessment_system.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreCreateDTO {
    private Long criteriaId;
    private Integer score;
    private String comment;
}