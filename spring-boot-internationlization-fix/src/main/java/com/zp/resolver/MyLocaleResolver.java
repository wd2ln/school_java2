package com.zp.resolver;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
@Component
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //从前端获取语言
        String lang = request.getParameter("lang");
        //从请求获取区域对象
        Locale locale;
        //判断语言是否为空
        if (lang!=null&&!lang.equals("")){
            //获取语言和地区
            String[] s = lang.split("_");
            //赋值给域对象
            locale=new Locale(s[0],s[1]);
        }else {
            // 给区域对象赋值
            locale = new Locale("en", "US");
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
