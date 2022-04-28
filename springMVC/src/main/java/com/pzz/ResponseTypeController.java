package com.pzz;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pzz.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("modelAndView")
public class ResponseTypeController {
    @RequestMapping("testMLV")
    public ModelAndView testModelAndView(){
        // 创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        // 设置属性键值对
        modelAndView.addObject("name","张珊珊");
        modelAndView.setViewName("/success.jsp");
        return modelAndView;
    }
    /**
     * 通过@ResponseBody注解返回void
     */
    @RequestMapping("testVoid")
    @ResponseBody
    public void testVoid(){
        System.out.println("测试ResponseBody注解");
    }

    /**
     * 测试返回json字符串
     */
    @ResponseBody
    @RequestMapping("testJson")
    public String testJson(){
        System.out.println("json字符串测试");
        User user = new User("tom",23,new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        String s=null;
        try {
            s = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }
    /**
     * 测试返回json对象
     */
    @ResponseBody
    @RequestMapping("testJsonObject")
    public User testJsonObject(){
        System.out.println("json对象测试");
        User user = new User("tom",23,new Date());

        return user;
    }
    /**
     * 测试返回map集合
     */
    @ResponseBody
    @RequestMapping("testMap")
    public Map<String,String> testMap(){
        System.out.println("Map测试");
        Map<String, String> map = new HashMap<>();
        map.put("user","tom");
        map.put("pwd","123");
        map.put("age","12");
        map.put("info","flljaweo");
        return map;
    }
}
