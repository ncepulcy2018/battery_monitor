package com.ncepulcy.battery_monitor.service.Impl;

import com.ncepulcy.battery_monitor.dao.ExportDao;
import com.ncepulcy.battery_monitor.entity.BatterySingleTest;
import com.ncepulcy.battery_monitor.service.ExportGetDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExportGetDataServiceImpl implements ExportGetDataService {
    @Autowired
    private ExportDao exportDao;
    @Override
    public List<BatterySingleTest> findAll() {

        return exportDao.findAll();
    }
}
