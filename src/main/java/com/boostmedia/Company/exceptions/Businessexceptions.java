package com.boostmedia.Company.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class Businessexceptions {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> companyNotFoundException(NoSuchElementException exp){
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exp.getMessage());
    }
}
