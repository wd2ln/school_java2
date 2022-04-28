package com.pzz;

import com.pzz.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("hello")
    public int test(){
        return 1/0;
    }
    @RequestMapping("hello1")
    public void test1()throws MyException{
        throw new MyException("报错");
    }
}
