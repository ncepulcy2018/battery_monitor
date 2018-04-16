package com.ncepulcy.battery_monitor.dao;

import com.ncepulcy.battery_monitor.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MenuDao {

	List<Menu> findPrimaryMenu();

	List<Menu> findByParentId(@Param("parentId") Long parentId);

}
