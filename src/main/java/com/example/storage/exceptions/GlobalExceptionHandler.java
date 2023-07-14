package com.example.storage.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<String> handleRestClientException(RestClientException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error occurred during API call! " + e.getMessage());
    }
    @ExceptionHandler(NotEnoughQuantityOfSelectedItemException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(NotEnoughQuantityOfSelectedItemException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("That was an invalid request input! " + e.getMessage());
    }
}