package com.example.employee_assessment_system.repository;

import com.example.employee_assessment_system.entity.AssessmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentHistoryRepository extends JpaRepository<AssessmentHistory, Integer> {
}
