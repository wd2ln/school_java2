package com.zp.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUpUtil {
    public static String fileup(MultipartFile multipartFile){
        //定义文件路径
        String path="/home/long-an/Downloads/apache-tomcat-8.5.75/webapps/upload";

        File file = new File(path);
        //验证路径
        if (!file.exists()){
            file.mkdirs();
        }
        //获取文件名
        String filename = multipartFile.getOriginalFilename();

        // 获取文件名的后缀名
        filename = filename.substring(filename.indexOf('.'));

        // 声明时间格式
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        // 获取当前时间的格式
        String format = dateFormat.format(new Date());

        // 拼接到文件名上
        filename = format + filename;
        //......
        try {
            multipartFile.transferTo(new File(file,filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/success.html";

    }
}
