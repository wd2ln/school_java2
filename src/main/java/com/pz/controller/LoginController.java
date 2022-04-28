package com.pz.controller;


import com.pz.dao.impl.LoginDaoImpl;
import com.pz.entity.User;
import com.pz.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理编码集
        req.setCharacterEncoding("utf-8");
        //获取前段数据
        String name = req.getParameter("uname");
        String pwd = req.getParameter("upwd");
        //调用M层方法进行判断
        User user = new User(name, pwd);
        LoginService loginService= new LoginService();
        boolean flag = loginService.loginUser(user);
        if (flag){//登录成功
            resp.sendRedirect("welcome.jsp");
        }else {
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
