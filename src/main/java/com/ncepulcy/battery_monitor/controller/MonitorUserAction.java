package com.ncepulcy.battery_monitor.controller;

import com.ncepulcy.battery_monitor.entity.MonitorUser;
import com.ncepulcy.battery_monitor.service.MonitorUserService;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/user")
public class MonitorUserAction {
    @Autowired
    private MonitorUserService monitorUserService;

    @RequestMapping("login")
    public String login(String name, String password, RedirectAttributes redirectAttributes, HttpSession httpSession){
        System.out.println("用户登录："+name+password);
        List mUserlist = monitorUserService.login(name,password);
        System.out.println(mUserlist) ;
        if (mUserlist!=null && !mUserlist.isEmpty()) {
            httpSession.removeAttribute("org.springframework.web.servlet.support.SessionFlashMapManager.FLASH_MAPS");
            redirectAttributes.addFlashAttribute("user", name);
            return "redirect:/manage_index.jsp";
        }
        else
            redirectAttributes.addFlashAttribute("message", "error");
            return "redirect:/error/error.jsp";
    }
//    @RequestMapping("login")
//    public String login(String name,String password,Model model){
//        System.out.println("用户登录："+name+password);
//
//        List mUserlist = monitorUserService.login(name,password);
//        System.out.println(mUserlist) ;
//        if (mUserlist!=null && !mUserlist.isEmpty()) {
//            System.out.println("not null");
//            model.addAttribute("msg", "登录成功");
//            return "redirect:/manage_index.jsp";
//        }
//        else
//            return "redirect:/index.jsp";
//    }
//    @RequestMapping("login")
//    public ModelAndView login(String name, String password){
//        System.out.println("用户登录："+name+password);
//
//        List mUserlist = monitorUserService.login(name,password);
//        System.out.println(mUserlist) ;
//        if (mUserlist!=null && !mUserlist.isEmpty()) {
//            System.out.println("not null");
//            ModelAndView mv=new ModelAndView("redirect:/manage_index.jsp");
//            mv.addObject("msg", "登录成功");
//            return mv;
//        }
//        else {
//            ModelAndView mv=new ModelAndView("redirect:/index.jsp");
//            return mv;
//        }
//    }

}
