package br.com.diolabs.childapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import br.com.diolabs.childapi.dto.ChildDTO;
import br.com.diolabs.childapi.model.Child;

public class ChildUtils {

    private static final long CHILD_ID = 1L;
    private static final String FIRST_NAME = "Anete";
    private static final String LAST_NAME = "Sisterhen";
    public static final LocalDate VALID_BIRTH_DATE = LocalDate.of(2013, 10, 1);
    public static final LocalDate INVALID_BIRTH_DATE = LocalDate.of(2009, 10, 1);

    public static ChildDTO createValidFakeDTO() {
        return ChildDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)               
                .birthDate("04-04-2011")
                .parents(Collections.singletonList(ParentUtils.createFakeDTO()))
                .build();
    }

    public static ChildDTO createInvalidFakeDTO() {
        return ChildDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)               
                .birthDate("04-04-2009")
                .parents(Collections.singletonList(ParentUtils.createFakeDTO()))
                .build();
    }

    public static Child createValidFakeEntity() {
        return Child.builder()
                .id(CHILD_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)               
                .birthDate(VALID_BIRTH_DATE)
                .parents(Collections.singletonList(ParentUtils.createFakeEntity()))
                .build();
    }   
    
    public static Child createInvalidFakeEntity() {
        return Child.builder()
                .id(CHILD_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)               
                .birthDate(INVALID_BIRTH_DATE)
                .parents(Collections.singletonList(ParentUtils.createFakeEntity()))
                .build();
    } 
}
