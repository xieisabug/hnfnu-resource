package com.hnfnu.zyw.service.system;

import java.awt.Menu;
import java.util.List;

public interface IMenuService {
	public void add(Menu menu);
	public void delete(int id);
	public void update(Menu menu);
	public Menu  load(int id);
	public List<Menu> list(String hql,Object[] args);
	public List<Menu> list(String hql);
}
