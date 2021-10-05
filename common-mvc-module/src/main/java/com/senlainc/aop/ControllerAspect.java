package com.senlainc.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAspect {

    private final Logger logger = LogManager.getLogger(ControllerAspect.class);

    @Before("execution(public * com.senlainc.controller.GroupController.*(..))")
    public void beforeLoggerGroupController(){
        logger.debug("ТЕКСТ ЛОГГЕРА ДО ВЫЗОВА МЕТОДА С АННОТАЦИЕЙ У МЕТОДА КОНТРОЛЛЕРА!");
    }
}
