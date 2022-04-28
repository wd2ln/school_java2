package com.zp.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SrocFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    // 跨域过滤器
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将请求转换成http类型的
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpServletRequest request=(HttpServletRequest) servletRequest;

        //添加请求头信息
        // 设置响应头
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, GET");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, x-requested-with");
        //获取请求源
        String origin = request.getHeader("Origin");
        System.out.println("获取的请求源是"+origin);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
