package com.zp.controller;

import com.zp.entity.TbUser;
import com.zp.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class TbUserController {
    @Autowired
    private TbUserService tbUserService;

    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String remember = request.getParameter("remember");

        TbUser status=null;
        if (remember != null) {
            Integer remember1=Integer.parseInt(remember);
            //获取登录状态
            status = tbUserService.login(username, password, remember1);
        }else {
            status = tbUserService.login(username, password,null);
        }
        //创建返回视图
        ModelAndView modelAndView =null;

        if (status!=null){
            //成功创建session
            HttpSession session = request.getSession(true);
            session.setAttribute("user",status);
            session.setMaxInactiveInterval(60*60);
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            if(remember!=null){
                if(Integer.parseInt(remember)==1){
                    cookie.setMaxAge(60*60);
                }
            }else {
                cookie.setMaxAge(0);
            }
            response.addCookie(cookie);
            modelAndView=new ModelAndView();
            modelAndView.setViewName("/index/page");
        }else {
            modelAndView=new ModelAndView();
            modelAndView.addObject("tbNote",status);
            modelAndView.addObject("code",0);
            modelAndView.addObject("message","登录失败，用户名密码错误");
            modelAndView.setViewName("/login.jsp");
        }
        return modelAndView;
    }
    @RequestMapping("logout")
    public ModelAndView loginout(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);
        // 判断session是否为空
        if (session != null) {
            session.invalidate();
        }

        // 通过 JSESSIONID 获取 cookie 对象
        Cookie cookie = new Cookie("JSESSIONID", "");

        // 设置 cookie 的有效期为 0
        cookie.setMaxAge(0);

        // 发送Cookie数据至浏览器
        response.addCookie(cookie);
        //创建返回视图
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("/login.jsp");
        return modelAndView;
    }
}
