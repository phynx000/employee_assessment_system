package com.example.employee_assessment_system.service;

import com.example.employee_assessment_system.dto.request.CriteriaCreateDTO;
import com.example.employee_assessment_system.dto.response.CriteriaDTO;
import com.example.employee_assessment_system.entity.Criteria;
import com.example.employee_assessment_system.entity.EvaluationTemplate;
import com.example.employee_assessment_system.mapper.CriteriaMapper;
import com.example.employee_assessment_system.repository.CriteriaRepository;
import com.example.employee_assessment_system.repository.EvaluationTemplateRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CriteriaService {

    private final CriteriaRepository criteriaRepository;
    private final EvaluationTemplateRepository templateRepository;
    private final CriteriaMapper criteriaMapper;

    @Autowired
    public CriteriaService(CriteriaRepository criteriaRepository,
                           EvaluationTemplateRepository templateRepository,
                           CriteriaMapper criteriaMapper) {
        this.criteriaRepository = criteriaRepository;
        this.templateRepository = templateRepository;
        this.criteriaMapper = criteriaMapper;
    }

    @Transactional(readOnly = true)
    public List<CriteriaDTO> getAllCriteria() {
        return criteriaMapper.toDTOList(criteriaRepository.findAll());
    }

    @Transactional(readOnly = true)
    public CriteriaDTO getCriteriaById(Long id) {
        return criteriaMapper.toDTO(criteriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Criteria not found with id: " + id)));
    }

    @Transactional(readOnly = true)
    public List<CriteriaDTO> getCriteriaByTemplateId(Long templateId) {
        EvaluationTemplate template = templateRepository.findById(templateId)
                .orElseThrow(() -> new EntityNotFoundException("Template not found with id: " + templateId));
        return criteriaMapper.toDTOList(criteriaRepository.findByTemplate(template));
    }

    @Transactional
    public CriteriaDTO createCriteria(CriteriaCreateDTO createDTO) {
        // Verify template exists
        templateRepository.findById(createDTO.getTemplateId())
                .orElseThrow(() -> new EntityNotFoundException("Template not found with id: " + createDTO.getTemplateId()));

        Criteria criteria = criteriaMapper.toEntity(createDTO);
        Criteria saved = criteriaRepository.save(criteria);

        return criteriaMapper.toDTO(saved);
    }

    @Transactional
    public void deleteCriteria(Long id) {
        if (!criteriaRepository.existsById(id)) {
            throw new EntityNotFoundException("Criteria not found with id: " + id);
        }
        criteriaRepository.deleteById(id);
    }
}