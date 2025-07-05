package com.example.AutoPecaMoto.presentation.handlers;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@RestControllerAdvice
public class ApiExcptionHandler {
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage>  entityNotFoundException(RuntimeException ex, HttpServletRequest request){
       
        log.error("Api Error - ", ex);// Consegue ver no console onde ocorreu o erro
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND) 
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage())); 
    }
}
