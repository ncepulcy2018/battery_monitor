package com.ncepulcy.battery_monitor.controller;

import com.ncepulcy.battery_monitor.util.EmailUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SendEmailAction {
    /**
     * 发送邮件
     * @return
     * @throws Exception
     */

    @RequestMapping(value="/sendEmail")
//    @ResponseBody
    public String sendEmail(){

        EmailUtil.sendEmail();
        return null;
    }
}
