package br.com.diolabs.childapi.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.diolabs.childapi.enums.PhoneTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private long id;

    @Enumerated(EnumType.STRING)
    private PhoneTypeEnum type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;

}
