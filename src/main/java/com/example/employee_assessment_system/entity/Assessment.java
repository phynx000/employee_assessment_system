package com.example.employee_assessment_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assessmentID;

    @JsonBackReference // Phía bị động của mối quan hệ
    @ManyToOne
    @JoinColumn(name = "employeeID", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "supervisorID", nullable = false)
    private Supervisor supervisor;

    private LocalDateTime assessmentDate;
    private String assessmentType;

    @JsonManagedReference // Phía chủ động của mối quan hệ
    @OneToMany(mappedBy = "assessment")
    private List<AssessmentHistory> assessmentHistories;

    // Getters and Setters
    public Integer getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(Integer assessmentID) {
        this.assessmentID = assessmentID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public LocalDateTime getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(LocalDateTime assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public List<AssessmentHistory> getAssessmentHistories() {
        return assessmentHistories;
    }

    public void setAssessmentHistories(List<AssessmentHistory> assessmentHistories) {
        this.assessmentHistories = assessmentHistories;
    }
}