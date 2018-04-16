package com.ncepulcy.battery_monitor.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ncepulcy.battery_monitor.entity.Menu;
import com.ncepulcy.battery_monitor.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;


@Path("menu")
public class MenuAction {

    @Autowired
    private MenuService menuService;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Menu> listPriMenu(){
        return menuService.findPrimaryMenu();
    }

    @GET
    @Path("{pid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Menu> listSecMenu(@PathParam("pid") Long pid){
        return menuService.findSecondaryMenu(pid);
    }
}
//import com.ncepulcy.battery_monitor.entity.Menu;
//import com.ncepulcy.battery_monitor.service.MenuService;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import java.util.List;
//
//@Controller
//@RequestMapping("/menu")
//public class MenuAction {
//
//	@Autowired
//	private MenuService menuService;
//
//    @RequestMapping("/primenu")
//    @ResponseBody
//	public List<Menu> listPriMenu(){
//        System.out.println("123");
//        List<Menu> menuList = menuService.findPrimaryMenu();
//        System.out.println(menuList);
//        for (Menu menu:menuList) {
//            System.out.println(menu);
//        }
////        model.addAttribute("list", menuList);
//		return menuList;
//	}
//
//    @RequestMapping("/primenu/{pid}")
//	public List<Menu> listSecMenu(@Param("pid") Long pid){
//		return menuService.findSecondaryMenu(pid);
//	}
//}
