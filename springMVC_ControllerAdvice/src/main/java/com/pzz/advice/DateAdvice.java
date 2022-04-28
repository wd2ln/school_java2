package com.pzz.advice;

import com.pzz.util.DateUtil;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

@ControllerAdvice
public class DateAdvice {
//    所有请求到达Controller前都执行此方法
    @InitBinder
    public void parseDate(WebDataBinder binder){
//        添加自定义的格式化器
        binder.addCustomFormatter(new DateUtil());
    }
    @InitBinder("student")
    public void student1(WebDataBinder binder){
//        添加自定义的格式化器
        binder.setFieldDefaultPrefix("student.");
    }
    @InitBinder("user")
    public void user1(WebDataBinder binder){
//        添加自定义的格式化器
        binder.setFieldDefaultPrefix("user.");
    }
    @ModelAttribute("createDate")
    public Date createDate(){
        return new Date();
    }
}
