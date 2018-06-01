package com.ncepulcy.battery_monitor.service.Impl;

import com.ncepulcy.battery_monitor.entity.BatterySingleTest;
import com.ncepulcy.battery_monitor.service.ExportService;
import com.ncepulcy.battery_monitor.util.ExportUtil;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.io.FileOutputStream;
import java.util.List;
@Service
public class ExportServiceImpl implements ExportService{

    @Override
    public void exportExcel(List<BatterySingleTest> userList, FileOutputStream out) {
        ExportUtil.exportUserExcel(userList, out);
    }
}
