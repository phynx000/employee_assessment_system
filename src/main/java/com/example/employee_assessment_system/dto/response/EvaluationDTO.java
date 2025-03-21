package com.example.employee_assessment_system.dto.response;

import com.example.employee_assessment_system.entity.Evaluation;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDTO {
    private Long id;
    private Long templateId;
    private Long employeeId;
    private Long evaluatorId;
    private Evaluation.EvaluationType evaluationType;
    private LocalDateTime evaluationDate;
    private List<ScoreDTO> scores;
}
