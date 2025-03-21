package com.example.employee_assessment_system.repository;

import com.example.employee_assessment_system.entity.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
}