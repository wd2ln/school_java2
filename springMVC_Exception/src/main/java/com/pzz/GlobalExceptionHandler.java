package com.pzz;

import com.pzz.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    // 声明对自定义异常的拦截
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Map<String,Object> test(MyException me){
        Map<String, Object> map = new HashMap<>();
        map.put("code",-1);
        map.put("message",me.getMessage());
        return map;
    }
    // 声明对系统异常的拦截
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Map<String,Object> test2(MyException me){
        Map<String, Object> map = new HashMap<>();
        map.put("code",-1);
        map.put("message",me.getMessage());
        return map;
    }
}
