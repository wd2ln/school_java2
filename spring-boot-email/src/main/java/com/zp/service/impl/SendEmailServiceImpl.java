package com.zp.service.impl;

import com.zp.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    //发送人
    String from="3068718524@qq.com";
    //接收人
    //String to="ssj011017@163.com";
    //String to="318601884@qq.com";
    //String to="1352515736@qq.com";
    //String to="3044753348@qq.com";
    String to="2508993136@qq.com";
    //String to="p30687185242021@163.com";
    //标题
    String subject="测试代码";
    //内容
   // String text="fack you ! I'm your father";
    String text = "<img src='https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2F1011%2F10051G30155%2F1G005130155-1-1200.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1653567405&t=fc705c49c6619cc50b06392276aecb31' alt='图片'/><font align='center' color='red'>网恋吗？哥哥，23单身</font>";
    @Override
    public void send() {
        /*简单邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);*/
        //复杂邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            //附件
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            File file = new File("/home/long-an/java文件idea/mvc_web_test/spring-boot-email/target/demo-0.0.1-SNAPSHOT.jar");
            File file1 = new File("/home/long-an/Documents/pzz/网页文件/京东系统/sao.html");
            helper.setFrom(from);
            helper.setText(text,true);
            helper.setTo(to);
            helper.setSubject(subject);
            //附件
            helper.addAttachment(file.getName(),file);
            helper.addAttachment("京东扫码.html",file1);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }
}
