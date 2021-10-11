package br.com.diolabs.childapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ChildNotFoundException extends RuntimeException{

    public ChildNotFoundException(Long id) {
        super("Child ID " + id + " not found.");
    }
    
}
