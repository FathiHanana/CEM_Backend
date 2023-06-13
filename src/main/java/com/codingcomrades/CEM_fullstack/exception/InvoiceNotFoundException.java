package com.codingcomrades.CEM_fullstack.exception;

public class InvoiceNotFoundException extends RuntimeException{
    public InvoiceNotFoundException(Long id){

        super("Could not found the invoice with id "+ id);
    }
}
