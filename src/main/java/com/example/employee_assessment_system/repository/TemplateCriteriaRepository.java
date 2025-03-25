package com.example.employee_assessment_system.repository;

import com.example.employee_assessment_system.entity.Score;
import com.example.employee_assessment_system.entity.TemplateCriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateCriteriaRepository extends JpaRepository<TemplateCriteria, Long> {
}
