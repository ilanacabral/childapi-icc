package br.com.diolabs.childapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ChildAgeException extends RuntimeException{
     public ChildAgeException(int age) {
        super("The child is " + age + " but the maximum age allowed is 10 years.");
    }
}
