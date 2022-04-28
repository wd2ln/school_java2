package com.zp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inter")
public class InterceptorController {
    @RequestMapping("test")
    public String test(){
        return "/login.html";
    }
}
