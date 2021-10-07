package com.senlainc.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GroupAspect {

    private static final Logger logger = LogManager.getLogger(GroupAspect.class);

    @Pointcut("@annotation(com.senlainc.enums.AopMarker)")
    public void callPointcut(){}

    //@Around("within(com.senlainc.service..*) && @annotation(com.senlainc.enums.AopMarker)")
    @Around("execution(* com.senlainc.service.GroupService.*(com.senlainc.dto.group.SaveGroupRequest)) || callPointcut()")
    public void groupAdvice(ProceedingJoinPoint proceedingJoinPoint){
        String methodName = proceedingJoinPoint.getSignature().getName();

        logger.info("-----Внутри метода groupAdvice----");
        logger.info("До вызова целевого метода!" + methodName);
        try {
            proceedingJoinPoint.proceed();
            logger.info("После вызова целевого метода " + methodName);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Before("callPointcut()")
    public void beforeAdvice(){
        logger.info("текст логгера внутри метода BEFORE ADVICE()");
        logger.debug("текст логгера уровня debug из beforeAdvice()");
    }


}
