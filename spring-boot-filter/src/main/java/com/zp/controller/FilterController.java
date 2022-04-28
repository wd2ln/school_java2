package com.zp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("filter")
public class FilterController {
    @RequestMapping("test1")
    public String test1(){
        return "filter1";
    }
    @RequestMapping("test2")
    public String test2(){
        return "filter3";
    }
}
