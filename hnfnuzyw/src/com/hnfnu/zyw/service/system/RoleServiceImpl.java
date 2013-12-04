package com.hnfnu.zyw.service.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IRoleDao;
import com.hnfnu.zyw.dto.system.RoleDto;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Autowired
	@Qualifier("roleDao")
	public IRoleDao roleDao;
	
	public boolean add(RoleDto role) {
		try {
			roleDao.add(role);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(RoleDto role) {
		try {
			roleDao.update(role);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public RoleDto load(RoleDto role) {
		if(role == null || role.getId() == null){
			return null;
		}
		RoleDto r = null;
		try {
			r = roleDao.load(role.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return r;
	}

	public boolean delete(RoleDto role) {
		if(role == null || role.getId() == null){
			return false;
		}
		try {
			roleDao.delete(role.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Map<String, Object> list() {
		Map<String, Object> m = new HashMap<String, Object>();
		List<RoleDto> l = null;
		try {
			l = roleDao.list("from RoleDto");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		m.put("Rows", l);
		m.put("Total", l.size());
		return m;
	}

}
