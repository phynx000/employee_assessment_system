package com.example.employee_assessment_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.employee_assessment_system.entity.Assessment;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {
} 