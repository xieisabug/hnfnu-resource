package com.hnfnu.zyw.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IMenuDao;
import com.hnfnu.zyw.dto.system.MenuDto;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {

	@Autowired
	@Qualifier("menuDao")
	public IMenuDao menuDao;// 暂时不写get set 试试可以不。

	public boolean add(MenuDto menu) {
		try {
			menuDao.add(menu);
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
		return false;
	}

	public boolean delete(int id) {
		try {
			menuDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(MenuDto menu) {
		try {
			menuDao.update(menu);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public MenuDto load(int id) {
		try {
			return menuDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<MenuDto> list(String hql, Object[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MenuDto> list(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

}
