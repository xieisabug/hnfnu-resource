package com.hnfnu.zyw.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IMenuDao;
import com.hnfnu.zyw.dao.system.IMenuVoDao;
import com.hnfnu.zyw.dto.system.MenuDto;
import com.hnfnu.zyw.vo.MenuVo;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {

	@Autowired
	@Qualifier("menuDao")
	public IMenuDao menuDao;
	
	@Autowired
	@Qualifier("menuVoDao")
	public IMenuVoDao menuVoDao;
	
	public boolean add(MenuDto menu) {
		try {
			if(menu.getParentId() == null){
				menu.setParentId(-1);
			}
			menuDao.add(menu);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
			return null;
		}
		
	}

	public List<MenuVo> list() {
		String hql = "from MenuVo";
		List<MenuVo> menus = null;
		try {
			menus = menuVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return menus;
	}

	public List<MenuDto> getMenusByParentId(int parentId) {
		String hql = "from MenuDto where parentId="+parentId; 
		List<MenuDto> menus = null;
		try {
			menus =  menuDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return menus;
	}


}
