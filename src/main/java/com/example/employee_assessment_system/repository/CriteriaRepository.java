package com.example.employee_assessment_system.repository;

import com.example.employee_assessment_system.entity.Criteria;
import com.example.employee_assessment_system.entity.EvaluationTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CriteriaRepository extends JpaRepository<Criteria, Long> {
    List<Criteria> findByTemplate(EvaluationTemplate template);
}

