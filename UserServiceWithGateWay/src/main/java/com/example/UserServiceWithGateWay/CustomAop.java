package com.example.UserServiceWithGateWay;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAop {

    @Around("execution ( public * com.example.UserServiceWithGateWay.*(..))")
    public Object validateUserService(ProceedingJoinPoint joinPoint){

        return null;

    }
}
