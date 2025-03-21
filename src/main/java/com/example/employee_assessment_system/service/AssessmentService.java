package com.example.employee_assessment_system.service;

import com.example.employee_assessment_system.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.employee_assessment_system.repository.AssessmentRepository;

@Service
public class AssessmentService {
    
    @Autowired
    private AssessmentRepository assessmentRepository;
    
    public ApiResponse deleteAssessment(Integer id) {
        if (!assessmentRepository.existsById(id)) {
            throw new RuntimeException("Assessment not found with id: " + id);
        }

        assessmentRepository.deleteById(id);
        return new ApiResponse(false,"Deleted assessment successfullly",null);
    }
} 