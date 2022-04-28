package com.zp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("filter")
public class FilterController {
    @CrossOrigin
    @RequestMapping("test")
    public Map<String, Object> get() {
        System.out.println("执行Controller");

        Map<String, Object> map = new HashMap<>();

        map.put("code", 200);
        map.put("message", "请求成功");

        return map;
    }
}
