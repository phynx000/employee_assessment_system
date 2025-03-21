package com.example.employee_assessment_system.service;

import com.example.employee_assessment_system.dto.request.EvaluationCreateDTO;
import com.example.employee_assessment_system.dto.response.EvaluationDTO;
import com.example.employee_assessment_system.entity.Criteria;
import com.example.employee_assessment_system.entity.Evaluation;
import com.example.employee_assessment_system.entity.Score;
import com.example.employee_assessment_system.entity.User;
import com.example.employee_assessment_system.mapper.EvaluationMapper;
import com.example.employee_assessment_system.mapper.ScoreMapper;
import com.example.employee_assessment_system.repository.CriteriaRepository;
import com.example.employee_assessment_system.repository.EvaluationRepository;
import com.example.employee_assessment_system.repository.EvaluationTemplateRepository;
import com.example.employee_assessment_system.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final UserRepository userRepository;
    private final EvaluationTemplateRepository templateRepository;
    private final CriteriaRepository criteriaRepository;
    private final UserService userService;
    private final EvaluationMapper evaluationMapper;
    private final ScoreMapper scoreMapper;

    @Autowired
    public EvaluationService(EvaluationRepository evaluationRepository,
                             UserRepository userRepository,
                             EvaluationTemplateRepository templateRepository,
                             CriteriaRepository criteriaRepository,
                             UserService userService,
                             EvaluationMapper evaluationMapper,
                             ScoreMapper scoreMapper) {
        this.evaluationRepository = evaluationRepository;
        this.userRepository = userRepository;
        this.templateRepository = templateRepository;
        this.criteriaRepository = criteriaRepository;
        this.userService = userService;
        this.evaluationMapper = evaluationMapper;
        this.scoreMapper = scoreMapper;
    }

    @Transactional(readOnly = true)
    public List<EvaluationDTO> getAllEvaluations() {
        return evaluationMapper.toDTOList(evaluationRepository.findAll());
    }

    @Transactional(readOnly = true)
    public EvaluationDTO getEvaluationById(Long id) {
        return evaluationMapper.toDTO(evaluationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evaluation not found with id: " + id)));
    }

    @Transactional(readOnly = true)
    public List<EvaluationDTO> getEvaluationsByEmployee(Long employeeId) {
        User employee = userRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId));
        return evaluationMapper.toDTOList(evaluationRepository.findByEmployee(employee));
    }

    @Transactional
    public EvaluationDTO createEvaluation(EvaluationCreateDTO createDTO) {
        // Validate template exists
        templateRepository.findById(createDTO.getTemplateId())
                .orElseThrow(() -> new EntityNotFoundException("Template not found with id: " + createDTO.getTemplateId()));

        // Validate employee exists
        userRepository.findById(createDTO.getEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + createDTO.getEmployeeId()));

        // Create evaluation
        Evaluation evaluation = evaluationMapper.toEntity(createDTO);

        // Set current user as evaluator
        evaluation.setEvaluator(userService.getCurrentUser());

        Evaluation savedEvaluation = evaluationRepository.save(evaluation);

        // Load all criteria to validate
        Map<Long, Criteria> criteriaMap = criteriaRepository.findByTemplate(evaluation.getTemplate()).stream()
                .collect(Collectors.toMap(Criteria::getId, c -> c));

        // Create scores
        List<Score> scores = new ArrayList<>();
        for (ScoreCreateDTO scoreDTO : createDTO.getScores()) {
            if (!criteriaMap.containsKey(scoreDTO.getCriteriaId())) {
                throw new EntityNotFoundException("Criteria not found with id: " + scoreDTO.getCriteriaId());
            }

            Score score = scoreMapper.toEntity(scoreDTO);
            score.setEvaluation(savedEvaluation);
            score.setCriteria(criteriaMap.get(scoreDTO.getCriteriaId()));
            scores.add(score);
        }

        savedEvaluation.setScores(scores);
        savedEvaluation = evaluationRepository.save(savedEvaluation);

        return evaluationMapper.toDTO(savedEvaluation);
    }
}