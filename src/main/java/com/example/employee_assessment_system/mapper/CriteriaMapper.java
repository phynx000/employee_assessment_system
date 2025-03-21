package com.example.employee_assessment_system.mapper;

import com.example.employee_assessment_system.dto.request.CriteriaCreateDTO;
import com.example.employee_assessment_system.dto.response.CriteriaDTO;
import com.example.employee_assessment_system.entity.Criteria;
import com.example.employee_assessment_system.entity.EvaluationTemplate;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CriteriaMapper {

    CriteriaDTO toDTO(Criteria criteria);

    List<CriteriaDTO> toDTOList(List<Criteria> criteria);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "template", source = "templateId", qualifiedByName = "templateIdToTemplate")
    Criteria toEntity(CriteriaCreateDTO criteriaCreateDTO);

    @Named("templateIdToTemplate")
    default EvaluationTemplate templateIdToTemplate(Long templateId) {
        if (templateId == null) {
            return null;
        }
        EvaluationTemplate template = new EvaluationTemplate();
        template.setId(templateId);
        return template;
    }
}