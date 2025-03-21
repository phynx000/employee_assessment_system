package com.example.employee_assessment_system.services;



import com.example.employee_assessment_system.dto.AssessmentDTO;
import com.example.employee_assessment_system.entity.*;
import com.example.employee_assessment_system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SupervisorRepository supervisorRepository;

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Autowired
    private AssessmentHistoryRepository assessmentHistoryRepository;

    public Assessment createAssessment(AssessmentDTO assessmentDTO) {
        Employee employee = employeeRepository.findById(assessmentDTO.getEmployeeID())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Supervisor supervisor = supervisorRepository.findById(assessmentDTO.getSupervisorID())
                .orElseThrow(() -> new RuntimeException("Supervisor not found"));

        Assessment assessment = new Assessment();
        assessment.setEmployee(employee);
        assessment.setSupervisor(supervisor);
        assessment.setAssessmentDate(assessmentDTO.getAssessmentDate());
        assessment.setAssessmentType(assessmentDTO.getAssessmentType());
        assessmentRepository.save(assessment);

        // Lưu trữ các tiêu chí đánh giá
        saveAssessmentHistory(assessment, "Kỹ năng", assessmentDTO.getSkillScore(), assessmentDTO.getSkillComments());
        saveAssessmentHistory(assessment, "Thái độ", assessmentDTO.getAttitudeScore(), assessmentDTO.getAttitudeComments());
        saveAssessmentHistory(assessment, "Hiệu suất", assessmentDTO.getPerformanceScore(), assessmentDTO.getPerformanceComments());
        saveAssessmentHistory(assessment, "Đóng góp", assessmentDTO.getContributionScore(), assessmentDTO.getContributionComments());

        return assessment;
    }

    private void saveAssessmentHistory(Assessment assessment, String criteriaName, Integer score, String comments) {
        Criteria criteria = criteriaRepository.findByCriteriaName(criteriaName)
                .orElseThrow(() -> new RuntimeException("Criteria not found: " + criteriaName));

        AssessmentHistory history = new AssessmentHistory();
        history.setAssessment(assessment);
        history.setCriteria(criteria);
        history.setScore(score);
        history.setComments(comments);
        assessmentHistoryRepository.save(history);
    }
}