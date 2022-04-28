package com.pzz.controller;

import com.pzz.entity.Student;
import com.pzz.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("object")
public class ObjectController {
    @RequestMapping("testObject")
    @ResponseBody
    public Map<String,Object> test(Student student, User user){
        Map<String, Object> map = new HashMap<>();
        map.put("student",student);
        map.put("user",user);
        return map;
    }
    @RequestMapping("createDateTest")
    @ResponseBody
    public Map<String,Object> test1(Student student, @ModelAttribute("createDate")Date date){
        Map<String, Object> map = new HashMap<>();
        student.setDate(date);
        map.put("student",student);
        return map;
    }
}
