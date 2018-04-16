package com.ncepulcy.battery_monitor.service.Impl;

import com.ncepulcy.battery_monitor.dao.BatterySingleTestDao;
import com.ncepulcy.battery_monitor.entity.BatterySingleTest;
import com.ncepulcy.battery_monitor.service.BatterySingleTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatterySingleTestServiceImpl implements BatterySingleTestService {
    @Autowired
    private BatterySingleTestDao batterySingleTestDao;

    public List<BatterySingleTest> findAll() {
        return batterySingleTestDao.findAll();
    }

    public List<BatterySingleTest> findByGroupID(String groupID) {
        return batterySingleTestDao.findByGroupID(groupID);
    }
}
