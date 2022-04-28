package com.pzz.advice;

import com.pzz.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Map<String,Object> handleSingletonDogException(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("code",-1);
        map.put("message","my name is tom");
        map.put("success",false);
        map.put("data",e.getMessage());
        return map;
    }
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String,Object> handleException(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("code",-1);
        map.put("message",e.getMessage());
        map.put("success",false);
        map.put("data",e.getMessage());
        return map;
    }
}
