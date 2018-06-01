package com.ncepulcy.battery_monitor.service;

import com.ncepulcy.battery_monitor.entity.BatterySingleTest;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.io.FileOutputStream;
import java.util.List;
@Service
public interface ExportService {
    public void exportExcel(List<BatterySingleTest> userList, FileOutputStream out);
}
