package com.hnfnu.zyw.service.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IRoleDao;
import com.hnfnu.zyw.dao.system.IUserRoleVoDao;
import com.hnfnu.zyw.dto.system.RoleDto;
import com.hnfnu.zyw.vo.UserRoleVo;

@Service("userRoleVoService")
public class UserRoleVoServiceImpl implements IUserRoleVoService {

	// 操作视图的dao
	@Autowired
	@Qualifier("userRoleVoDao")
	public IUserRoleVoDao userRoleVoDao;

	// 操作 角色表的dao
	@Autowired
	@Qualifier("roleDao")
	public IRoleDao roleDao;

	public Map<String, Object> roleByUser(int id) {
		List<UserRoleVo> _selected = null;
		List<RoleDto> roles = null;
		
		List<RoleDto> selected = new ArrayList<RoleDto>();;
		List<RoleDto> unSelected = new ArrayList<RoleDto>();
		Map<String, Object> result = new HashMap<String, Object>();
		String sql = "from UserRoleVo where userId=" + id;
		String hql = "from RoleDto";
		try {
			_selected = userRoleVoDao.list(sql);
			roles = roleDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		for (int i = 0; i < roles.size(); i++) {
			
			int j;
			int roleId = roles.get(i).getId();
			for (j = 0; j < _selected.size(); j++) {
				if (_selected.get(j).getRoleId() == roleId) {
					selected.add(roles.get(i));
					break;
				}
			}

			System.out.println("selected = " + selected.size());
			System.out.println("unselected" + unSelected.size());
			if (j >= _selected.size()) {
				System.out.println("此时的i = "+ i);
				System.out.println("没有被选的角色"+roles.get(i));
				unSelected.add(roles.get(i));
			}
		}
		result.put("selected", selected);
		result.put("unSelected", unSelected);
		return result;

	}

}
