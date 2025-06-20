
package com.example.AutoPecaMoto.presentation.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.AutoPecaMoto.domain.exeptions.CpfUniqueViolationExecption;
import com.example.AutoPecaMoto.domain.exeptions.EmailUniqueViolationExecption;
import com.example.AutoPecaMoto.domain.exeptions.HandlerNotFoundException;
 
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request, BindingResult result){

                log.error("Api Error - ", ex);
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)  
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, "Campo(s) invalido(s).", result)); 
        }
        
        @ExceptionHandler(HandlerNotFoundException.class)
        public ResponseEntity<ErrorMessage>  handlerNotFoundException(RuntimeException ex, HttpServletRequest request){
        
                log.error("Api Error - ", ex); 
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)  
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage())); 
        }

        @ExceptionHandler({CpfUniqueViolationExecption.class, EmailUniqueViolationExecption.class})
        public ResponseEntity<ErrorMessage> dataIntegrityViolationException(RuntimeException ex, HttpServletRequest request){
        
                log.error("Api Error - ", ex);
                return ResponseEntity
                        .status(HttpStatus.CONFLICT) 
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new ErrorMessage(request, HttpStatus.CONFLICT, ex.getMessage())); 
        }

        // @ExceptionHandler(Exception.class)
        // public ResponseEntity<ErrorMessage> internalServerErrorException(Exception ex, HttpServletRequest request){
        // ErrorMessage error = new ErrorMessage(
        // request, HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()
        // );

        // log.error("Internal Server Error {} {}",error, ex.getMessage());// Consegue ver no console onde ocorreu o erro
        // return ResponseEntity
        //         .status(HttpStatus.INTERNAL_SERVER_ERROR)
        //         .contentType(MediaType.APPLICATION_JSON)
        //         .body(error);
        // }

         
}
