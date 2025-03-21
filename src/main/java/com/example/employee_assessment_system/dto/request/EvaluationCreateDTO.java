package com.example.employee_assessment_system.dto.request;

import com.example.employee_assessment_system.entity.Evaluation;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationCreateDTO {
    private Long templateId;
    private Long employeeId;
    private Evaluation.EvaluationType evaluationType;
    private List<ScoreCreateDTO> scores;
}