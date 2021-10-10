package br.com.diolabs.childapi.exception;

public class ChildNotFoundException extends RuntimeException{

    public ChildNotFoundException(Long id) {
        super("Child ID " + id + " not found.");
    }
    
}
