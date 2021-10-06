package com.senlainc.controller;

import com.senlainc.aop.TestObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    TestObject testObject = new TestObject();

    @GetMapping("/aspect")
    public void testing(){
        testObject.getSimpleString();
    }
}
