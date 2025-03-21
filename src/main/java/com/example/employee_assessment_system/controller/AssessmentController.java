package com.example.employee_assessment_system.controller;

import com.example.employee_assessment_system.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String deleteAssessment(@PathVariable int id) {
        return assessmentService.deleteAssessment(id);
    }
}
