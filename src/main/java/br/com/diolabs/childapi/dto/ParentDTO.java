package br.com.diolabs.childapi.dto;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import br.com.diolabs.childapi.enums.ParentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParentDTO {

    private Long id;
    
    @NotEmpty
    @Size(min=2,max=100)
    private String firstName;
    
    @NotEmpty
    @Size(min=2,max=100)
    private String lastName;    

    @NotEmpty
    @CPF
    private String cpf;

    @Enumerated(EnumType.STRING)
    private ParentTypeEnum type;
    
    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

    private List<ChildDTO> children;
    
}
