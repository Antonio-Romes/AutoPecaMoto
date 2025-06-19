package com.example.AutoPecaMoto.domain.exeptions;

public class HandlerMethodNotAllowedException extends RuntimeException {
    public HandlerMethodNotAllowedException(String message){
        super(message);
    }
}
