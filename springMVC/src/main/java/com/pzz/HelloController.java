package com.pzz;

import com.pzz.entity.MapAndList;
import com.pzz.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("login")
    public String goIndex(){

        System.out.println("login");
        return "/login.jsp";
    }
    @RequestMapping("success")
    public String goIndex1(){

        System.out.println("success");
        return "/success.jsp";
    }
    @RequestMapping("test")
    public String test(User user){
        System.out.println(user);
        return "/success.jsp";
    } @RequestMapping("ListAndMap")
    public String testListAndMap(MapAndList mapAndList){
        System.out.println(mapAndList);
        return "/success.jsp";
    }
}
