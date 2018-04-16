package com.ncepulcy.battery_monitor.dao;

import com.ncepulcy.battery_monitor.entity.BatterySingleTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BatterySingleTestDao {
    public List<BatterySingleTest> findAll();

    public List<BatterySingleTest> findByGroupID(@Param("groupID") String groupID);
}
