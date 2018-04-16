package com.ncepulcy.battery_monitor.service;

import com.ncepulcy.battery_monitor.entity.BatterySingleTest;

import java.util.List;

public interface BatterySingleTestService {
    public List<BatterySingleTest> findAll();

    public List<BatterySingleTest> findByGroupID(String groupID);
}
