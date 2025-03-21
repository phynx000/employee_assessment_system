package com.example.employee_assessment_system.mapper;

import com.example.employee_assessment_system.dto.request.EvaluationCreateDTO;
import com.example.employee_assessment_system.dto.response.EvaluationDTO;
import com.example.employee_assessment_system.entity.Evaluation;
import com.example.employee_assessment_system.entity.EvaluationTemplate;
import com.example.employee_assessment_system.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {ScoreMapper.class})
public interface EvaluationMapper {

    @Mapping(target = "templateId", source = "template.id")
    @Mapping(target = "employeeId", source = "employee.id")
    @Mapping(target = "evaluatorId", source = "evaluator.id")
    EvaluationDTO toDTO(Evaluation evaluation);

    List<EvaluationDTO> toDTOList(List<Evaluation> evaluations);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "template", source = "templateId", qualifiedByName = "templateIdToTemplate")
    @Mapping(target = "employee", source = "employeeId", qualifiedByName = "userIdToUser")
    @Mapping(target = "evaluator", ignore = true)
    @Mapping(target = "evaluationDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "scores", ignore = true)
    Evaluation toEntity(EvaluationCreateDTO evaluationCreateDTO);

    @Named("templateIdToTemplate")
    default EvaluationTemplate templateIdToTemplate(Long templateId) {
        if (templateId == null) {
            return null;
        }
        EvaluationTemplate template = new EvaluationTemplate();
        template.setId(templateId);
        return template;
    }

    @Named("userIdToUser")
    default User userIdToUser(Long userId) {
        if (userId == null) {
            return null;
        }
        User user = new User();
        user.setId(userId);
        return user;
    }
}