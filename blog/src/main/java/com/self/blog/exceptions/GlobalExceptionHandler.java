package com.self.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.self.blog.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourcenotfound(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        
        return new ResponseEntity<>(new ApiResponse(message, false), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validationFalils(MethodArgumentNotValidException ex) {
        
        Map<String, String> mpMap=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((ex1)-> {
        	    String field_nameString=(((FieldError) ex1).getField());
        	    String messageString=ex1.getDefaultMessage();
        	    mpMap.put(field_nameString, messageString);
        });
         
        return new ResponseEntity<>(mpMap, HttpStatus.NOT_FOUND);
    }
//    
    
}

