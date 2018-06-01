package com.ncepulcy.battery_monitor.service;

import com.ncepulcy.battery_monitor.entity.BatterySingleTest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ExportGetDataService {
    public List<BatterySingleTest> findAll();
}
