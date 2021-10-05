package com.senlainc.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

    private final Logger logger = LogManager.getLogger(TestAspect.class);

    @Before("within(com.senlainc.service.PrivilegeService+)")
    public void testBeforeAspect(){
        System.out.println("выведется в консоль");
        logger.info("текст логгера уровня info");
        logger.debug("текст логгера уровня debug");
        logger.info("текст логгера уровня info");
        logger.debug("текст логгера уровня debug");
    }
}
