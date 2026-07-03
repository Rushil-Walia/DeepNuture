package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Runs before any method in the service package
    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore() {
        System.out.println("[AOP] Method execution starting...");
    }

    // Runs after the method finishes
    @After("execution(* com.library.service.*.*(..))")
    public void logAfter() {
        System.out.println("[AOP] Method execution finished.");
    }

    // Calculates method execution time
    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        
        Object proceed = joinPoint.proceed(); // Let the method run
        
        long executionTime = System.currentTimeMillis() - start;
        System.out.println("[AOP] " + joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }
}