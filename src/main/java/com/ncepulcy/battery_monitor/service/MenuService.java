package com.ncepulcy.battery_monitor.service;



import com.ncepulcy.battery_monitor.entity.Menu;

import java.util.List;

public interface MenuService {

	List<Menu> findPrimaryMenu();

	List<Menu> findSecondaryMenu(Long parentId);

	
}
