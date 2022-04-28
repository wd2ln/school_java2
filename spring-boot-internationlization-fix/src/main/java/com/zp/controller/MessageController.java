package com.zp.controller;

import com.zp.util.MessageUtils;
import com.zp.vo.LocaleVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("i18n")
public class MessageController {
    @GetMapping("get")
    public LocaleVO get(){
        System.out.println("start .....");
        LocaleVO locale = new LocaleVO();
        locale.setLogin(MessageUtils.get("login"));
        locale.setPassword(MessageUtils.get("password"));
        locale.setUsername(MessageUtils.get("username"));
        locale.setWelcome(MessageUtils.get("welcome"));
        locale.setTitle(MessageUtils.get("title"));
        locale.setRememberMe(MessageUtils.get("rememberMe"));
        return locale;
    }
}
