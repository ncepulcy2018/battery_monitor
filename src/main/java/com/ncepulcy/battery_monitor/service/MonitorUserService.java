package com.ncepulcy.battery_monitor.service;

import com.ncepulcy.battery_monitor.entity.MonitorUser;

import java.util.List;

public interface MonitorUserService {
    public void regist(MonitorUser user);
    public List<MonitorUser> login(String name, String password);
}
