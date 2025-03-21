package com.example.employee_assessment_system.controller;

import com.example.employee_assessment_system.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteEvaluationById(Long id) {
        return null;
    }
}
