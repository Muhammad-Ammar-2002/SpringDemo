package com.SpringDemo.Logs;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Validation {

    private static final Logger LOGGER = LoggerFactory.getLogger(Validation.class);

    @Around("execution(* com.SpringDemo.Service.StudentService.getStudentById(..)) && args(id)")
    public Object monitorTime(ProceedingJoinPoint joinPoint, Integer id) throws Throwable {

        LOGGER.info("Called method {} with id {}" ,joinPoint.getSignature().getName(),id);

        if(id < 0)
        {

            id=-id;
            LOGGER.info("Update method {} with id {}" ,joinPoint.getSignature().getName(),id);



        }
        Object obj = joinPoint.proceed(new Object[]{id});

        LOGGER.info("Executed method {} wit returned values {}", joinPoint.getSignature().getName(), obj);
        return obj;
    }
}
