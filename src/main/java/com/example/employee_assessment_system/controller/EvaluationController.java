package com.example.employee_assessment_system.controller;

import com.example.employee_assessment_system.dto.request.EvaluationCreateDTO;
import com.example.employee_assessment_system.dto.response.EvaluationDTO;
import com.example.employee_assessment_system.service.EvaluationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    private final EvaluationService evaluationService;

    @Autowired
    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPERVISOR', 'ADMIN')")
    public ResponseEntity<List<EvaluationDTO>> getAllEvaluations() {
        return ResponseEntity.ok(evaluationService.getAllEvaluations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluationDTO> getEvaluationById(@PathVariable Long id) {
        return ResponseEntity.ok(evaluationService.getEvaluationById(id));
    }

    @GetMapping("/employee/{employeeId}")
    @PreAuthorize("hasAnyRole('SUPERVISOR', 'ADMIN') or @userSecurity.isSameUser(#employeeId)")
    public ResponseEntity<List<EvaluationDTO>> getEvaluationsByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(evaluationService.getEvaluationsByEmployee(employeeId));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERVISOR', 'ADMIN')")
    public ResponseEntity<EvaluationDTO> createEvaluation(@Valid @RequestBody EvaluationCreateDTO evaluationCreateDTO) {
        EvaluationDTO created = evaluationService.createEvaluation(evaluationCreateDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}