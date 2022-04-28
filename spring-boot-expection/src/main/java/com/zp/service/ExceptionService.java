package com.zp.service;

import com.zp.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionService{
    @ExceptionHandler(MyException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> testMy(MyException e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();

        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());

        return map;
    }
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public Map<String, Object> testException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());

        return map;
    }
}
