package com.codingcomrades.CEM_fullstack.exception;

public class CEMleaveNotFoundException extends RuntimeException{
    public CEMleaveNotFoundException(Long id){

        super("Could not found the cemleave with id "+ id);
    }
}
