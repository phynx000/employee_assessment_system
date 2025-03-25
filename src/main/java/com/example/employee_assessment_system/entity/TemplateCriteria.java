package com.example.employee_assessment_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "template_criteria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateCriteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id", nullable = false)
    private EvaluationTemplate template;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "criteria_id", nullable = false)
    private Criteria criteria;

    // Có thể thêm trọng số hoặc thứ tự đánh giá nếu cần
    private Integer weight;

    private Integer displayOrder;
}