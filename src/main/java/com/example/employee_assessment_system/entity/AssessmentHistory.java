package com.example.employee_assessment_system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class AssessmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assessmentHistoryID;

    @JsonBackReference // Phía bị động của mối quan hệ
    @ManyToOne
    @JoinColumn(name = "assessmentID", nullable = false)
    private Assessment assessment;

    @ManyToOne
    @JoinColumn(name = "criteriaID", nullable = false)
    private Criteria criteria;

    private Integer score;
    private String comments;

    // Getters and Setters
    public Integer getAssessmentHistoryID() {
        return assessmentHistoryID;
    }

    public void setAssessmentHistoryID(Integer assessmentHistoryID) {
        this.assessmentHistoryID = assessmentHistoryID;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}