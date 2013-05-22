package com.hnfnu.zyw.service.system;


import java.util.List;

import com.hnfnu.zyw.dto.system.MenuDto;

public interface IMenuService {
	public boolean add(MenuDto menu);
	public boolean delete(int id);
	public boolean update(MenuDto menu);
	public MenuDto  load(int id);
	/**
	 * 查询数据库所有记录
	 * @return
	 */
	public List<MenuDto> list();
}
