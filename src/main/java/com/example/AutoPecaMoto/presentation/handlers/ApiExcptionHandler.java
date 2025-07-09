package com.example.AutoPecaMoto.presentation.handlers;
 
import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@RestControllerAdvice
public class ApiExcptionHandler {
    
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorMessage>  accessDeniedException(AccessDeniedException ex, HttpServletRequest request){
       
        log.error("Api Error - ", ex); 
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)  
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.FORBIDDEN, ex.getMessage())); 
    }

    @ExceptionHandler({
    //PasswordInvalidException.class,
    MethodArgumentNotValidException.class,
    //ConstraintViolationException.class,
    HttpMessageNotReadableException.class
})
    public ResponseEntity<ErrorMessage>  passwordInvalidException(RuntimeException ex, HttpServletRequest request){
       
        log.error("Api Error - ", ex);// Consegue ver no console onde ocorreu o erro

        String errorMessage = "Requisição inválida";
        // if (ex instanceof PasswordInvalidException) {
        //     errorMessage = ex.getMessage();
        // } else if (ex instanceof MethodArgumentNotValidException) {
        //     errorMessage = "Dados de entrada inválidos";
        // } else if (ex instanceof ConstraintViolationException) {
        //     errorMessage = "Violação de constraints de validação";
        //} else 
        if (ex instanceof HttpMessageNotReadableException) {
            errorMessage = "Corpo da requisição inválido ou malformado";
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // status 409, indica que teve conflido ao inserir dado no banco, ex campo unico
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, ex.getMessage())); 
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage>  entityNotFoundException(RuntimeException ex, HttpServletRequest request){
       
        log.error("Api Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND) 
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage())); 
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request, BindingResult result){
       
        log.error("Api Error - ", ex); 
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.UNPROCESSABLE_ENTITY, "Campo(s) invalido(s).", result ));  
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> internalServerErrorException(Exception ex, HttpServletRequest request){
       ErrorMessage error = new ErrorMessage(
        request, HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()
       );

        log.error("Internal Server Error {} {}",error, ex.getMessage());// Consegue ver no console onde ocorreu o erro
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(error);
    }
}
