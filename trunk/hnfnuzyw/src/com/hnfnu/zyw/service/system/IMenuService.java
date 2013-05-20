package com.hnfnu.zyw.service.system;


import java.util.List;

import com.hnfnu.zyw.dto.system.MenuDto;

public interface IMenuService {
	public boolean add(MenuDto menu);
	public boolean delete(int id);
	public boolean update(MenuDto menu);
	public MenuDto  load(int id);
	public List<MenuDto> list(String hql,Object[] args);
	public List<MenuDto> list(String hql);
}
