package com.example.employee_assessment_system.repository;

import com.example.employee_assessment_system.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {
}
