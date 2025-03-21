package com.example.employee_assessment_system.controller;

import com.example.employee_assessment_system.dto.ApiResponse;
import com.example.employee_assessment_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable int id) {
        ApiResponse response = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(response);
    }
}
