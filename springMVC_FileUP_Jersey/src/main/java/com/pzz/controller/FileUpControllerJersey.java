package com.pzz.controller;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("fileUp1")
public class FileUpControllerJersey {
    @RequestMapping("test1")
    public ModelAndView test(MultipartFile file,ModelAndView mv){
        System.out.println("跨域上传test开始.....");
        // 准备一个跨域存放图片的路径
        String filePath="http://localhost:8888/images/";
        System.out.println("开始获取上传文件的名称.....");
        // 获取上传文件的名称
        String name = file.getOriginalFilename();
        System.out.println("获取上传文件的名称成功.....");
        //获取文件后缀名
        String fixFileName = name.substring(name.lastIndexOf("."));

        // 声明时间格式
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        // 获取当前时间的格式
        String format = dateFormat.format(new Date());

        // 拼接到文件名上
        String filename=format+fixFileName;
        try {
        // 创建客户端对象
        Client client = Client.create();
        // 连接到图片服务器
        WebResource resource = client.resource(filePath + filename);
            // 上传文件
            resource.put(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 设置要跳转的路径
        mv.setViewName("/success.jsp");

        return mv;
    }

}
