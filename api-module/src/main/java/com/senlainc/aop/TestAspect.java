package com.senlainc.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    private final Logger logger = LogManager.getLogger(TestAspect.class);

    private Log log = LogFactory.getLog(this.getClass());

    @Before("execution(* com.senlainc.service.MessageService.*(..))")
    public void testBeforeAspect(){
        System.out.println("выведется в консоль");
        logger.info("текст логгера уровня info");
        logger.debug("текст логгера уровня debug");
        logger.info("текст логгера уровня info");
        logger.debug("текст логгера уровня debug");

        log.info("текст из второго логгера уровня info");
        log.debug("текст из второго логгера логгера уровня debug");
    }


}
