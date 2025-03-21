package com.example.employee_assessment_system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationTemplateDTO {
    private Long id;
    private String name;
    private String description;
    private List<CriteriaDTO> criteria = new ArrayList<>();
}