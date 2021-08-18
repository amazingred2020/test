package com.senlainc;

import com.senlainc.dto.user.AddFriendRequest;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfiguration.class);
        UserService userService = context.getBean(UserService.class);
        AddFriendRequest request = new AddFriendRequest();
        request.setUserFrom(2l);
        request.setUserTo(1l);
        request.setButtonName("confirm");
    }
}
