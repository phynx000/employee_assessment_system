package com.example.employee_assessment_system.controller;

import com.example.employee_assessment_system.dto.ApiResponse;
import com.example.employee_assessment_system.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assessment")
public class AssessmentController {
    @Autowired
    private AssessmentService assessmentService;

    @PostMapping
    public void createAssessment() {}

    @GetMapping("/")
    public String getAssessment() {
        return "Hello World";
    }
    
    @PutMapping
    public void updateAssessment() {}

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAssessment(@PathVariable int id) {
        return new ResponseEntity<ApiResponse>(assessmentService.deleteAssessment(id), HttpStatus.OK);
    }
}
