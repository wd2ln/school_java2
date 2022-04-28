package com.pzz;

import org.apache.commons.io.FileUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
//设置一级访问路径
@RequestMapping("fileDown")
public class DownLoadController {
    @RequestMapping("go")
    public String stu(Model mOdel, String fileName){
        mOdel.addAttribute("img",fileName);
        return "/index.jsp";
    }


    /**
     * 下载文件代码块儿
     * @param fileName 文件名
     * @param response  响应头
     * @return
     */
    //设置二级访问路径
    @RequestMapping("start")
    public ModelAndView fileDown(String fileName, HttpServletResponse response){
        //设置文件下载路径
        String path="/home/long-an/Downloads/apache-tomcat-10.0.16/webapps/ROOT/images";
        // 使用路径和文件名创建File对象
        File file = new File(path, fileName);
        // 设置响应头告知浏览器以下载的方式打开
        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
        // 声明输入输出流
        BufferedInputStream inputStream=null;
        ServletOutputStream outputStream=null;
        try {
            outputStream = response.getOutputStream();
            inputStream=new BufferedInputStream(new FileInputStream(file));
            // 准备缓冲区8kB
            byte[] bytes = new byte[1024 * 8];

            while (inputStream.read(bytes)!=-1){
                // 写入数据
                outputStream.write(bytes);
//                刷新缓冲
                outputStream.flush();
            }
        } catch (IOException e) {

        }finally {
//            关闭资源
            try {
                if (outputStream!=null){

                    outputStream.close();
                }
                if (inputStream!=null){

                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @RequestMapping("download")
    public ResponseEntity<byte[]> downLoad(String name){
        //设置文件下载路径
        String path="/home/long-an/Downloads/apache-tomcat-10.0.16/webapps/ROOT/images";
        // 使用路径和文件名创建File对象
        File file = new File(path, name);
        HttpHeaders httpHeaders = new HttpHeaders();
//        设置文件下载方式
        httpHeaders.setContentDispositionFormData("attachment",name);
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file),httpHeaders, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
