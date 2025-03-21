package com.example.employee_assessment_system.controller;

import org.springframework.web.bind.annotation.*;

@RestController()
public class AssessmentController {

    @PostMapping
    public void createAssessment() {}

    @GetMapping
    public String getAssessment() {
        return "Hello World";
    }
    
    @PutMapping
    public void updateAssessment() {}

    @DeleteMapping
    public void deleteAssessment() {}
}
