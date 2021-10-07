package com.senlainc.aop;

import com.senlainc.dto.comment.SaveCommentRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/*
@Component
@Aspect
public class CommentAspect {

    private static final Logger logger = LogManager.getLogger(CommentAspect.class);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Pointcut("execution(* com.senlainc.service.CommentService.addComment(..))")
    public void commentPerformance(){}

    @Around("commentPerformance() && args(request)")
    public void watchCommentingPosts(ProceedingJoinPoint jp, SaveCommentRequest request){

        String methodName = jp.getSignature().getName();
        String className = jp.getSignature().getDeclaringTypeName();
        Object[] arguments = jp.getArgs();

        try{
            logger.info("Вызов логгера до вызова метода создания или изменения комментария!");
            logger.info("Название вызываемого класса: " + className);
            logger.info("Название вызываемого метода " + methodName);
            logger.info("Список аргументов целевого класса: ");
            for (Object argument : arguments) {
                logger.info("\t" + argument);
            }
            logger.info("Текущее время вызова: " + LocalDateTime.now().format(formatter));
            logger.info("Аргумент целевого метода: " + request);

            jp.proceed();

            logger.info("Вызов логгера после вызова метода создания или изменения комментария!");
            logger.info("Текущее время вызова: " + LocalDateTime.now().format(formatter));
        } catch (Throwable exception){
            logger.warn("Вызов логгера из блока CATCH метода watchCommentingPosts()");
            logger.info("Текущее время вызова: " + LocalDateTime.now().format(formatter));
        }
    }
}
 */
