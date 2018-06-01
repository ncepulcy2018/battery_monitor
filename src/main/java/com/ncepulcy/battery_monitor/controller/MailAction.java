package com.ncepulcy.battery_monitor.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;

//@ContextConfiguration(classes={Mail.class, WebConfig.class})
//@WebAppConfiguration
//@Controller
@RequestMapping("/mail")
public class MailAction {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(){
        SimpleMailMessage message = new SimpleMailMessage();//消息构造器
        message.setFrom("cculiuchongyang@163.com");//发件人
        message.setTo("ncepulcy@126.com");//收件人
        message.setSubject("Spring Email Test");//主题
        message.setText("hello world!!");//正文
        mailSender.send(message);
        System.out.println("邮件发送完毕");
    }

}
