package com.pzz;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("fileUp")
public class FileUpController {
    @RequestMapping("test")
    public ModelAndView test(MultipartFile file,ModelAndView mv){
        System.out.println("test开始");
        // 准备一个存放图片的路径
        String filePath="/data/home/long-an/Downloads/apache-tomcat-10.0.16/webapps/ROOT/images";
        // 创建File对象
        File file1 = new File(filePath);
        // 如果当前路径为空
        if (!file1.exists()){
            // 创建该文件夹的多级目录
            file1.mkdirs();
        }

        // 说明上传文件项
        // 获取上传文件的名称
        String name = file.getOriginalFilename();
        try {
                // 如果文件名称不为空
                if (name!=null) {
                    // 完成文件上传
                     file.transferTo(new File(filePath, name));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        // 创建ModelAndView对象
        //ModelAndView modelAndView = new ModelAndView();
        // 将图片的路径Model中
        mv.addObject("img","http://localhost:8888/images/"+name);
        // 设置要跳转的路径
        mv.setViewName("/success.jsp");

        return mv;
    }
    @RequestMapping("tt")
    public String test(){
        return "/success.jsp";
    }
}
