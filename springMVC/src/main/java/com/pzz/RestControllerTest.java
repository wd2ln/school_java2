package com.pzz;

import com.pzz.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//相当于 @ResponseBody ＋ @Controller
@RestController
@RequestMapping("restCon")
public class RestControllerTest {
    @RequestMapping("user")
    public User user(){

        return new User("tom",23,new Date());
    }
}
