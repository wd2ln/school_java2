package com.zp.controller;

import com.zp.exception.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
@RestController
@RequestMapping("exception")
public class ExceptionController {
    @RequestMapping("system")
    public void testSystem(){
        System.out.println("发生算数异常");
        int i=1/0;
    }
    @RequestMapping("myex")
    public void testMyException() throws MyException {
        System.out.println("发生自定义异常");
            throw new MyException("发生自定义异常");

    }
}
