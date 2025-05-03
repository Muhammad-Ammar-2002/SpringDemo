package com.SpringDemo.Logs;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    private static final Logger LOGGER = LoggerFactory.getLogger(Logging.class);

    @Before("execution(* com.SpringDemo.Service.StudentService.updateStudent(..)) || execution(* com.SpringDemo.Controller.HelloController.*(..))")
    public void logMethodCalled(JoinPoint joinPoint) {
        LOGGER.info("Method called : {}" , joinPoint.getSignature().getName());
    }


    @AfterReturning("execution(* com.SpringDemo.Service.StudentService.updateStudent(..)) || execution(* com.SpringDemo.Controller.HelloController.*(..))")
    public void logMethodExecuted(JoinPoint joinPoint) {
        LOGGER.info("Method Executed : {}" , joinPoint.getSignature().getName());

    }

    @AfterThrowing("execution(* com.SpringDemo.*.*.*(..)) ")
    public void logMethodThrowing(JoinPoint joinPoint) {
        LOGGER.error("Method has some issues : {}", joinPoint.getSignature().getName());
    }





}
