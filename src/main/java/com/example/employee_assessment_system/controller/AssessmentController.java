package com.example.employee_assessment_system.controller;

import com.example.employee_assessment_system.dto.ApiResponse;
import com.example.employee_assessment_system.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import com.example.employee_assessment_system.dto.AssessmentDTO;
import com.example.employee_assessment_system.entity.Assessment;
import com.example.employee_assessment_system.services.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assessments")
=======
@RestController
@RequestMapping("/api/assessment")
>>>>>>> 7e99c11070347af65f55265fe1955af4c11d3a18
public class AssessmentController {
    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private AssessmentService assessmentService;

    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<Assessment> createAssessment(@RequestBody AssessmentDTO assessmentDTO) {
        Assessment assessment = assessmentService.createAssessment(assessmentDTO);
        return ResponseEntity.ok(assessment);
    }
=======
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
>>>>>>> 7e99c11070347af65f55265fe1955af4c11d3a18
}
