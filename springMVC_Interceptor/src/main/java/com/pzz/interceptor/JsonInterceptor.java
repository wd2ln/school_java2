package com.pzz.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pzz.entity.Codes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class JsonInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("查询缓存....");
        HttpSession session = request.getSession(false);
        if (session==null){
            return true;
        }
        Object list = session.getAttribute("list");
        if (list==null){
            return true;
        }
        System.out.println("查到了缓存...");
        Codes codes = new Codes(200,"查到缓存",true,list);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(codes));

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView!=null){
            Map<String, Object> model = modelAndView.getModel();
            Object list = model.get("list");
            System.out.println("放入缓存。。。。");

            HttpSession session = request.getSession(true);
            session.setAttribute("list",list);
            Codes codes = new Codes(200,"没有查到缓存",true,list);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(new ObjectMapper().writeValueAsString(codes));
        }
    }
}
