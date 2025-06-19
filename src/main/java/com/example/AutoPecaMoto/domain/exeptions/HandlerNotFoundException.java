package com.example.AutoPecaMoto.domain.exeptions;

public class HandlerNotFoundException extends RuntimeException {

    public HandlerNotFoundException(String message){
        super(message);
    }
    
}
