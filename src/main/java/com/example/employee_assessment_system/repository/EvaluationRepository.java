package com.example.employee_assessment_system.repository;

import com.example.employee_assessment_system.entity.Evaluation;
import com.example.employee_assessment_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    List<Evaluation> findByEmployee(User employee);
    List<Evaluation> findByEvaluator(User evaluator);
    List<Evaluation> findByEmployeeAndEvaluationType(User employee, Evaluation.EvaluationType type);
}