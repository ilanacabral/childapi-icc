package br.com.diolabs.childapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import br.com.diolabs.childapi.dto.ParentDTO;
import br.com.diolabs.childapi.enums.ParentTypeEnum;
import br.com.diolabs.childapi.model.Parent;

public class ParentUtils {
    private static final long PARENT_ID = 1L;
    private static final String FIRST_NAME = "Dieter Joaquim";
    private static final String LAST_NAME = "Sisterhen";
    private static final String CPF_NUMBER = "666.118.938-06";
    private static final ParentTypeEnum PARENT_TYPE = ParentTypeEnum.FATHER;
   
    public static final LocalDate BIRTH_DATE = LocalDate.of(1976, 10, 1);

    public static ParentDTO createFakeDTO() {
        return ParentDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)               
                .cpf(CPF_NUMBER)
                .type(PARENT_TYPE)                
               // .children(Collections.singletonList(ChildUtils.createValidFakeDTO()))
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();               
    }

    public static Parent createFakeEntity() {
        return Parent.builder()
                .id(PARENT_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)      
                .type(PARENT_TYPE) 
                //.children(Collections.singletonList(ChildUtils.createValidFakeEntity()))            
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
