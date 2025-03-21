package com.example.employee_assessment_system.repository;


import com.example.employee_assessment_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}