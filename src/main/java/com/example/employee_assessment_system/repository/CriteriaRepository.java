package com.example.employee_assessment_system.repository;
import com.example.employee_assessment_system.entity.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CriteriaRepository extends JpaRepository<Criteria, Integer> {
    Optional<Criteria> findByCriteriaName(String criteriaName);
}