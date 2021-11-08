package com.johanseet.notasescolares.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Long id){
        super("No se encuentra el estudiante " + id);
    }
}
