package com.senlainc.spring;

import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.config.SecurityConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CustomWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SecurityConfiguration.class, JpaConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses()  {
        return new Class[] {SpringMVCConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}