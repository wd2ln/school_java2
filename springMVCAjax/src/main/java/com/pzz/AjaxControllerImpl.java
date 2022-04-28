package com.pzz;

import com.pzz.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("ajaxControllerImpl")
public class AjaxControllerImpl  {

    @RequestMapping("ajaxTest")
    public Map<String,Object> ajaxTest(User user) {
        System.out.println(user);
        Map<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("data","66666");
        return map;
    }
}
