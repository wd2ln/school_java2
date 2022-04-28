package com.zp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("origin")
@CrossOrigin
public class OriginController {
    @RequestMapping("test")
    public String test(){
        return "请求跨域过滤器";
    }
}
