package com.pzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dog")
public class DogController {
    @RequestMapping("test")
    public String user(){
        return "/success.jsp";
    }
}
