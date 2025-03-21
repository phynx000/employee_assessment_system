package com.example.employee_assessment_system.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Criteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer criteriaID;

    private String criteriaName;
    private String description;

    @OneToMany(mappedBy = "criteria")
    private List<AssessmentHistory> assessmentHistories;

    // Getters and Setters
    public Integer getCriteriaID() {
        return criteriaID;
    }

    public void setCriteriaID(Integer criteriaID) {
        this.criteriaID = criteriaID;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AssessmentHistory> getAssessmentHistories() {
        return assessmentHistories;
    }

    public void setAssessmentHistories(List<AssessmentHistory> assessmentHistories) {
        this.assessmentHistories = assessmentHistories;
    }
}
