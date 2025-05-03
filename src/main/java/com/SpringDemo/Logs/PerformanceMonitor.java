package com.SpringDemo.Logs;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitor.class);

    @Around("execution(* com.SpringDemo.Service.StudentService.getAllStudents(..))")
    public Object monitorTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();


        Object obj = joinPoint.proceed();


        long endTime = System.currentTimeMillis();

        LOGGER.info("Time Taken by {} = {} ms" ,joinPoint.getSignature().getName(), endTime-startTime);

        return obj;
    }


}
