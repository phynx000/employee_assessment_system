package com.example.employee_assessment_system.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDTO {
    private Long id;
    private Long criteriaId;
    private Integer score;
    private String comment;
}
