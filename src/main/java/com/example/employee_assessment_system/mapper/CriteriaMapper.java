package com.example.employee_assessment_system.mapper;

import com.example.employee_assessment_system.dto.request.CriteriaCreateDTO;
import com.example.employee_assessment_system.dto.response.CriteriaDTO;
import com.example.employee_assessment_system.entity.Criteria;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CriteriaMapper {

    CriteriaDTO toDTO(Criteria criteria);

    List<CriteriaDTO> toDTOList(List<Criteria> criteria);

    @Mapping(target = "id", ignore = true)
    Criteria toEntity(CriteriaCreateDTO criteriaCreateDTO);
}
