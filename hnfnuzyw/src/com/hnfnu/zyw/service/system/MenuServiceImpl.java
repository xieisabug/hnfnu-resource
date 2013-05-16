package com.hnfnu.zyw.service.system;

import java.awt.Menu;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IMenuDao;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {

	@Autowired
	@Qualifier("menuDao")
	public IMenuDao menuDao;//��ʱ��дget set ���Կ��Բ���

	public void add(Menu menu) {
		try {
			menuDao.add(menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			menuDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(Menu menu) {
		try {
			menuDao.update(menu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Menu load(int id) {
		try {
			return menuDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Menu> list(String hql, Object[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Menu> list(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

}
