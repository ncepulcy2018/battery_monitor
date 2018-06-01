package com.ncepulcy.battery_monitor.controller;


import com.ncepulcy.battery_monitor.entity.BatterySingleTest;
import com.ncepulcy.battery_monitor.service.ExportGetDataService;
import com.ncepulcy.battery_monitor.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import java.io.FileOutputStream;
import java.util.List;

@Controller
@RequestMapping("/excel")
public class ExportAction {
    @Autowired
    private ExportGetDataService exportGetDataService;
    @Autowired
    private ExportService exportService;

    @RequestMapping("export")
    public String exportExcel(HttpServletResponse response)
    {
        try
        {
            //1.查找用户列表
            List<BatterySingleTest> userList = exportGetDataService.findAll();
            //2.导出
            //这里设置的文件格式是application/x-excel
//            response.setContentType("application/x-excel");
//            response.setHeader("Content-Disposition", "attachment;filename=" + new String("用户列表.xls".getBytes(), "ISO-8859-1"));
//            ServletOutputStream outputStream = response.getOutputStream();
            FileOutputStream outputStream = new FileOutputStream("/user.xls");//指定路径与名字和格式
            exportService.exportExcel(userList, outputStream);
            if(outputStream != null)
                outputStream.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
