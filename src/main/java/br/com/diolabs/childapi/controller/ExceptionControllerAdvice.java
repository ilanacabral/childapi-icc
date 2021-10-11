package br.com.diolabs.childapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.diolabs.childapi.dto.MessageResponseDTO;
import br.com.diolabs.childapi.exception.ChildAgeException;
import br.com.diolabs.childapi.exception.ChildNotFoundException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ChildNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageResponseDTO notFound(){
        return MessageResponseDTO.builder().message("Child not found.").build();
    }

    @ExceptionHandler(ChildAgeException.class)   
    public MessageResponseDTO invalidAge(){
        return MessageResponseDTO.builder().message("The child has an invalid age.").build();
    }
    
}
