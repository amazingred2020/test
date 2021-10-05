package com.senlainc.aop;

import com.senlainc.dto.message.SaveMessageRequest;
import com.senlainc.entity.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Aspect
public class MessageAspect {

    private static final Logger logger = LogManager.getLogger(MessageAspect.class);

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Pointcut("execution(* com.senlainc.service.MessageService.sendMessage(..))")
    public void messagePerformance(){}

    @Before("messagePerformance()")
    public void beforeSendLogging(JoinPoint joinPoint){

        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        String kind = joinPoint.getKind();
        String targetClass = joinPoint.getTarget().getClass().getName();
        String aspectClass = joinPoint.getThis().getClass().getName();

        logger.info("Вызов логгера перед отправкой сообщения!");
        logger.info("-----" + className + "." + methodName + " () -----");
        logger.debug("Тип точки соединения: " + kind);
        logger.info("Список аргументов целевого класса: ");
        logger.debug("Тип класса, на который применен аспект: " + targetClass);
        logger.debug("Тип класса аспекта: " + aspectClass);
        for (Object argument : arguments) {
            logger.info("\t" + argument);
        }
        logger.info("Текущее время вызова: " + LocalDateTime.now().format(formatter));
    }

    @AfterReturning(pointcut = "messagePerformance() and args(request)", returning = "returnValue")
    public void afterSendReturning(JoinPoint joinPoint, SaveMessageRequest request, Message returnValue){
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        logger.info("Вызов логгера после возврата метода отправки сообщения!");
        logger.info("Агрумент целевого метода: " + request);
        logger.info("-----" + className + "." + methodName + "() -----");
        logger.info("Возвращаемое значение метода = " + returnValue);
        logger.info("Текущее время вызова: " + LocalDateTime.now().format(formatter));
    }

    @AfterThrowing(pointcut = "messagePerformance()", throwing = "exception")
    public void afterSendThrowing(JoinPoint joinPoint, Exception exception){
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        logger.info("Вызов логгера после неудачного вызова метода отправки сообщения!");
        logger.info("-----" + className + "." + methodName + "() -----");
        logger.info("Текст исключения: " + exception.getMessage());
        logger.info("Текущее время вызова: " + LocalDateTime.now().format(formatter));
    }
}
