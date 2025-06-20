package com.example.AutoPecaMoto.domain.exeptions;

public class EmailUniqueViolationExecption extends RuntimeException {
    
    public EmailUniqueViolationExecption(String message){
        super(message);
    }
}
