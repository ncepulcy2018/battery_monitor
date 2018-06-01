package com.ncepulcy.battery_monitor.dao;

import com.ncepulcy.battery_monitor.entity.BatterySingleTest;

import java.util.List;

public interface ExportDao {
    public List<BatterySingleTest> findAll();
}
