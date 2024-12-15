package com.example.UserServiceWithGateWay;

public class UserNameNotFoundExeption extends RuntimeException {
    public UserNameNotFoundExeption(String message) {
        super(message);
    }
}
