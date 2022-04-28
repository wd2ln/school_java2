package com.pzz.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) {
// 创建一个modelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        // 判断抛出的异常类型是否是自定义异常并添加到modelAndView中
        if (ex instanceof MyException){
            modelAndView.addObject("message","自定义异常"+ ex.getMessage());
        }else {
            modelAndView.addObject("message",ex.getMessage());
        }
        modelAndView.setViewName("/error.jsp");
        return modelAndView;
    }
}
