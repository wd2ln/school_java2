package com.pzz;

import com.pzz.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("pathVariable")
public class PathVariableTest {
    /**
     * 测试参数绑定
     * @param id
     * @return
     */
    @GetMapping("test1/{id}")
    public String test1(@PathVariable("id") Integer id){
        System.out.println("查询：" + id);
        return "/success.jsp";
    }

    /**
     * 测试json
     */
    @RequestMapping("test2")
    public String test2(@RequestBody String json){
        System.out.println("查询：" + json);
        return "/success.jsp";
    }
    /**
     * 测试json对象
     */
    @RequestMapping(path = "test3",consumes = "application/json;charset:utf-8")
    public String test3(@RequestBody User json){
        System.out.println("查询：" + json);
        return "/success.jsp";
    }

}
