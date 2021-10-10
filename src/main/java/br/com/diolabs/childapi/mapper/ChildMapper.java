package br.com.diolabs.childapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import br.com.diolabs.childapi.dto.ChildDTO;
import br.com.diolabs.childapi.model.Child;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ChildMapper {
   
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Child toModel(ChildDTO childDTO);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    ChildDTO toDTO(Child child);
}
