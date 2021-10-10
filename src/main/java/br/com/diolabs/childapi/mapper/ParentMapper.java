package br.com.diolabs.childapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import br.com.diolabs.childapi.dto.ParentDTO;
import br.com.diolabs.childapi.model.Parent;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParentMapper {   
   
    Parent toModel(ParentDTO parentDTO);   
    ParentDTO toDTO(Parent parent);
}
