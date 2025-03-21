package com.example.employee_assessment_system.mapper;

import com.example.employee_assessment_system.dto.request.ScoreCreateDTO;
import com.example.employee_assessment_system.dto.response.ScoreDTO;
import com.example.employee_assessment_system.entity.Criteria;
import com.example.employee_assessment_system.entity.Score;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ScoreMapper {

    @Mapping(target = "criteriaId", source = "criteria.id")
    ScoreDTO toDTO(Score score);

    List<ScoreDTO> toDTOList(List<Score> scores);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "evaluation", ignore = true)
    @Mapping(target = "criteria", source = "criteriaId", qualifiedByName = "criteriaIdToCriteria")
    Score toEntity(ScoreCreateDTO scoreCreateDTO);

    @Named("criteriaIdToCriteria")
    default Criteria criteriaIdToCriteria(Long criteriaId) {
        if (criteriaId == null) {
            return null;
        }
        Criteria criteria = new Criteria();
        criteria.setId(criteriaId);
        return criteria;
    }
}