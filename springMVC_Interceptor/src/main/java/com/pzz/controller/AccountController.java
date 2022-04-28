package com.pzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {
    @RequestMapping("test")
    public ModelAndView test(ModelAndView mv){
        System.out.println("连接数据库...");
        //模拟数据库连接
        List<String> list = new ArrayList<>();

        list.add("列表1");
        list.add("列表2");
        list.add("列表3");
        mv.addObject("list",list);
        mv.setViewName("/account/test");
        return mv;
    }
}
