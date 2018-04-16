package com.ncepulcy.battery_monitor.service.Impl;

import com.ncepulcy.battery_monitor.dao.MenuDao;
import com.ncepulcy.battery_monitor.entity.Menu;
import com.ncepulcy.battery_monitor.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
    private MenuDao menuDao;
	
	public List<Menu> findPrimaryMenu() {
		return menuDao.findPrimaryMenu();
	}

	public List<Menu> findSecondaryMenu(Long parentId) {
		return menuDao.findByParentId(parentId);
	}
}
