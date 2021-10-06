package com.senlainc.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class GroupAspect {

    private static final Logger logger = LogManager.getLogger(GroupAspect.class);

    //@Around("within(com.senlainc.service..*) && @annotation(com.senlainc.enums.AopMarker)")
    @Around("execution(* com.senlainc.service.GroupService.*(..))")
    public void groupAdvice(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("-----Внутри метода groupAdvice----");
        logger.info("До вызова целевого метода!");
        try {
            proceedingJoinPoint.proceed();
            logger.info("После вызова целевого метода!");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
