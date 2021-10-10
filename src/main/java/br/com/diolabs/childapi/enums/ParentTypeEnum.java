package br.com.diolabs.childapi.enums;

import java.io.FileNotFoundException;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ParentTypeEnum {

    FATHER("Father"),
    MOTHER("Mother"),
    GRANDMOTHER("Grandmother"),
    GRANDFATHER("Grandfather"),
    TUTOR("Tutor");

    private final String description;

    public static ParentTypeEnum getParentTypeEnum(String description) throws FileNotFoundException {        
        return Stream.of(values()).filter(p->p.getDescription().equals(description)).findFirst().orElseThrow(FileNotFoundException::new);      
    }  
    
}
