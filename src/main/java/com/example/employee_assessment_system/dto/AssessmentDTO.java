package com.example.employee_assessment_system.dto;

import java.time.LocalDateTime;

public class AssessmentDTO {
    private Integer employeeID;
    private Integer supervisorID;
    private LocalDateTime assessmentDate;
    private String assessmentType;
    private Integer skillScore;
    private String skillComments;
    private Integer attitudeScore;
    private String attitudeComments;
    private Integer performanceScore;
    private String performanceComments;
    private Integer contributionScore;
    private String contributionComments;

    // Getters and Setters
    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(Integer supervisorID) {
        this.supervisorID = supervisorID;
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

    public Integer getSkillScore() {
        return skillScore;
    }

    public void setSkillScore(Integer skillScore) {
        this.skillScore = skillScore;
    }

    public String getSkillComments() {
        return skillComments;
    }

    public void setSkillComments(String skillComments) {
        this.skillComments = skillComments;
    }

    public Integer getAttitudeScore() {
        return attitudeScore;
    }

    public void setAttitudeScore(Integer attitudeScore) {
        this.attitudeScore = attitudeScore;
    }

    public String getAttitudeComments() {
        return attitudeComments;
    }

    public void setAttitudeComments(String attitudeComments) {
        this.attitudeComments = attitudeComments;
    }

    public Integer getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(Integer performanceScore) {
        this.performanceScore = performanceScore;
    }

    public String getPerformanceComments() {
        return performanceComments;
    }

    public void setPerformanceComments(String performanceComments) {
        this.performanceComments = performanceComments;
    }

    public Integer getContributionScore() {
        return contributionScore;
    }

    public void setContributionScore(Integer contributionScore) {
        this.contributionScore = contributionScore;
    }

    public String getContributionComments() {
        return contributionComments;
    }

    public void setContributionComments(String contributionComments) {
        this.contributionComments = contributionComments;
    }
}