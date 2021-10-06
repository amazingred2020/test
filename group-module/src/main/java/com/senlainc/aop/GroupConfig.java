package com.senlainc.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class GroupConfig {

    @Bean
    public GroupAspect getGroupAspect(){
        return new GroupAspect();
    }
}
