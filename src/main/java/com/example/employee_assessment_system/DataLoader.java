package com.example.employee_assessment_system;


import com.example.employee_assessment_system.entity.*;
import com.example.employee_assessment_system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SupervisorRepository supervisorRepository;

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Autowired
    private AssessmentHistoryRepository assessmentHistoryRepository;


    private void createCriteriaIfNotExists(String criteriaName, String description) {
        if (!criteriaRepository.findByCriteriaName(criteriaName).isPresent()) {
            Criteria criteria = new Criteria();
            criteria.setCriteriaName(criteriaName);
            criteria.setDescription(description);
            criteriaRepository.save(criteria);
        }
    }


    @Override
    public void run(String... args) throws Exception {

//        createCriteriaIfNotExists("Kỹ năng", "Evaluation of technical skills and knowledge");
//        createCriteriaIfNotExists("Thái độ", "Evaluation of attitude");
//        createCriteriaIfNotExists("Hiệu suất", "Evaluation of performance");
//        createCriteriaIfNotExists("Đóng góp", "Evaluation of contributions");
//
//
//
//        // Tạo dữ liệu mẫu cho Supervisor
//        Supervisor supervisor1 = new Supervisor();
//        supervisor1.setName("John Doe");
//        supervisor1.setPosition("Senior Manager");
//        supervisor1.setDepartment("IT");
//        supervisorRepository.save(supervisor1);
//
//        Supervisor supervisor2 = new Supervisor();
//        supervisor2.setName("Jane Smith");
//        supervisor2.setPosition("Manager");
//        supervisor2.setDepartment("HR");
//        supervisorRepository.save(supervisor2);
//
//        // Tạo dữ liệu mẫu cho Employee
//        Employee employee1 = new Employee();
//        employee1.setName("Alice Johnson");
//        employee1.setPosition("Software Engineer");
//        employee1.setDepartment("IT");
//        employee1.setSupervisor(supervisor1);
//        employeeRepository.save(employee1);
//
//        Employee employee2 = new Employee();
//        employee2.setName("Bob Brown");
//        employee2.setPosition("HR Specialist");
//        employee2.setDepartment("HR");
//        employee2.setSupervisor(supervisor2);
//        employeeRepository.save(employee2);
//
//        // Tạo dữ liệu mẫu cho Criteria
//        Criteria criteria1 = new Criteria();
//        criteria1.setCriteriaName("Technical Skills");
//        criteria1.setDescription("Evaluation of technical skills and knowledge");
//        criteriaRepository.save(criteria1);
//
//        Criteria criteria2 = new Criteria();
//        criteria2.setCriteriaName("Communication");
//        criteria2.setDescription("Evaluation of communication skills");
//        criteriaRepository.save(criteria2);
//
//        // Tạo dữ liệu mẫu cho Assessment
//        Assessment assessment1 = new Assessment();
//        assessment1.setEmployee(employee1);
//        assessment1.setSupervisor(supervisor1);
//        assessment1.setAssessmentDate(LocalDateTime.now());
//        assessment1.setAssessmentType("Monthly");
//        assessmentRepository.save(assessment1);
//
//        Assessment assessment2 = new Assessment();
//        assessment2.setEmployee(employee2);
//        assessment2.setSupervisor(supervisor2);
//        assessment2.setAssessmentDate(LocalDateTime.now());
//        assessment2.setAssessmentType("Quarterly");
//        assessmentRepository.save(assessment2);
//
//        // Tạo dữ liệu mẫu cho AssessmentHistory
//        AssessmentHistory history1 = new AssessmentHistory();
//        history1.setAssessment(assessment1);
//        history1.setCriteria(criteria1);
//        history1.setScore(8);
//        history1.setComments("Good technical skills, needs improvement in advanced topics");
//        assessmentHistoryRepository.save(history1);
//
//        AssessmentHistory history2 = new AssessmentHistory();
//        history2.setAssessment(assessment1);
//        history2.setCriteria(criteria2);
//        history2.setScore(7);
//        history2.setComments("Effective communication, but can improve in team collaboration");
//        assessmentHistoryRepository.save(history2);
//
//        AssessmentHistory history3 = new AssessmentHistory();
//        history3.setAssessment(assessment2);
//        history3.setCriteria(criteria1);
//        history3.setScore(6);
//        history3.setComments("Basic technical skills, needs more training");
//        assessmentHistoryRepository.save(history3);
//
//        AssessmentHistory history4 = new AssessmentHistory();
//        history4.setAssessment(assessment2);
//        history4.setCriteria(criteria2);
//        history4.setScore(9);
//        history4.setComments("Excellent communication skills");
//        assessmentHistoryRepository.save(history4);


    }
}