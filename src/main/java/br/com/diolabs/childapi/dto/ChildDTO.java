package br.com.diolabs.childapi.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChildDTO {

    private Long id;
    
    @NotEmpty
    @Size(min=2,max=100)
    private String firstName;
    
    @NotEmpty
    @Size(min=2,max=100)
    private String lastName;   

    private String birthDate;    
    
    @Valid
    @NotEmpty
    private List<ParentDTO> parents;
    
}
