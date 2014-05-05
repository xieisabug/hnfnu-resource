package com.hnfnu.zyw.service.system;


import java.util.List;

import com.hnfnu.zyw.dto.system.MenuDto;
import com.hnfnu.zyw.vo.MenuVo;

public interface IMenuService {
	public boolean add(MenuDto menu);
	public boolean delete(int id);
	public boolean update(MenuDto menu);
	public MenuDto  load(int id);
	/**
	 * 查询数据库所有记录
	 * @return
	 */
	public List<MenuVo> list();
	//根据parentId得到该菜单的所有子菜单，如果parentId是-1，则说明查找的事所有的一级菜单
		public List<MenuDto> getMenusByParentId(int parentId);
}
