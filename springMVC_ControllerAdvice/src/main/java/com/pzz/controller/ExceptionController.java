package com.pzz.controller;


import com.pzz.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("exception")
public class ExceptionController {
    /**
     * 测试系统异常 by / zero
     *
     */
    @RequestMapping("test")
    public String test(){
        int i=1/0;

        return "/index.jsp";
    }
    /**
     * 测试自定义异常
     *
     * @throws MyException 抛出自定义异常
     */
    @RequestMapping("myTest")
    public void test2() throws MyException {
        throw new MyException("报错");
    }

    /**
     *
     * @param date 传入的日期
     */
    @RequestMapping("date")
    public void testDate(Date date){
        System.out.println(date);
    }


}
