package com.ncepulcy.battery_monitor.service.Impl;

import com.ncepulcy.battery_monitor.dao.MonitorUserDao;
import com.ncepulcy.battery_monitor.entity.MonitorUser;
import com.ncepulcy.battery_monitor.service.MonitorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorServiceImpl implements MonitorUserService{

    @Autowired
    private MonitorUserDao monitorUserDao;

    public void regist(MonitorUser user) {
        monitorUserDao.addUser(user);
    }

    public List<MonitorUser> login(String name, String password) {
        return monitorUserDao.findUserByNameAndPwd(name, password);
    }
}
