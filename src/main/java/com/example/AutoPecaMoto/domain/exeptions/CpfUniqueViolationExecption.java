package com.example.AutoPecaMoto.domain.exeptions;

public class CpfUniqueViolationExecption extends RuntimeException {
    
    public CpfUniqueViolationExecption(String message){
        super(message);
    }
}
