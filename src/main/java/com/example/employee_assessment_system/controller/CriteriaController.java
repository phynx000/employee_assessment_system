package com.example.employee_assessment_system.controller;

import com.example.employee_assessment_system.dto.request.CriteriaCreateDTO;
import com.example.employee_assessment_system.dto.response.CriteriaDTO;
import com.example.employee_assessment_system.service.CriteriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/criteria")
public class CriteriaController {

    private final CriteriaService criteriaService;

    @Autowired
    public CriteriaController(CriteriaService criteriaService) {
        this.criteriaService = criteriaService;
    }

    @GetMapping
    public ResponseEntity<List<CriteriaDTO>> getAllCriteria() {
        return ResponseEntity.ok(criteriaService.getAllCriteria());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriteriaDTO> getCriteriaById(@PathVariable Long id) {
        return ResponseEntity.ok(criteriaService.getCriteriaById(id));
    }

    @GetMapping("/template/{templateId}")
    public ResponseEntity<List<CriteriaDTO>> getCriteriaByTemplateId(@PathVariable Long templateId) {
        return ResponseEntity.ok(criteriaService.getCriteriaByTemplateId(templateId));
    }

    @PostMapping
//    @PreAuthorize("hasAnyRole('SUPERVISOR', 'ADMIN')")
    public ResponseEntity<CriteriaDTO> createCriteria(@Valid @RequestBody CriteriaCreateDTO criteriaCreateDTO) {
        CriteriaDTO created = criteriaService.createCriteria(criteriaCreateDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteCriteria(@PathVariable Long id) {
        criteriaService.deleteCriteria(id);
        return ResponseEntity.noContent().build();
    }
}