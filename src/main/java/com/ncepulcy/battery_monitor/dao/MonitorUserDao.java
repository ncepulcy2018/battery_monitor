package com.ncepulcy.battery_monitor.dao;

import com.ncepulcy.battery_monitor.entity.MonitorUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MonitorUserDao {
    public void addUser(MonitorUser monitorUser);

    public List<MonitorUser> findUserByNameAndPwd(@Param("userName") String userName, @Param("password") String password);
}
