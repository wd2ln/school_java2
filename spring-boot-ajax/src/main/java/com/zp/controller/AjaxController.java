package com.zp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("ajax")
public class AjaxController {
    @RequestMapping("test")
    public Map<String ,Object> test(String name,String password){
        Map<String, Object> map = new HashMap<>();
        if (!name.equals("tom")){
            map.put("code",400);
        }
        map.put("code",200);
        return map;
    }
}
