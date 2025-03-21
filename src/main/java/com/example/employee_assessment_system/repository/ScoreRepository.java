package com.example.employee_assessment_system.repository;

import com.example.employee_assessment_system.entity.Evaluation;
import com.example.employee_assessment_system.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByEvaluation(Evaluation evaluation);
}