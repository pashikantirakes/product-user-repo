package com.example.UserServiceWithGateWay;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = UserNameNotFoundExeption.class)
    public ResponseEntity<String> handleUserNameException(UserNameNotFoundExeption un){
return new ResponseEntity<>(un.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
