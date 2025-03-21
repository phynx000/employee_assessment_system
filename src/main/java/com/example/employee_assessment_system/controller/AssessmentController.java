package com.example.employee_assessment_system.controller;

import org.springframework.web.bind.annotation.*;

import com.example.employee_assessment_system.dto.AssessmentDTO;
import com.example.employee_assessment_system.entity.Assessment;
import com.example.employee_assessment_system.services.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @PostMapping
    public ResponseEntity<Assessment> createAssessment(@RequestBody AssessmentDTO assessmentDTO) {
        Assessment assessment = assessmentService.createAssessment(assessmentDTO);
        return ResponseEntity.ok(assessment);
    }
}
