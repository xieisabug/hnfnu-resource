package com.hnfnu.zyw.dao.system;

import java.util.List;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.RoleMenuJoinDto;

public interface IRoleMenuJoinDao extends IBaseDao<RoleMenuJoinDto> {

	// 通过角色id和菜单id得到一个RoleMenuJoin实体

	public RoleMenuJoinDto uniqueLoad(String hql) throws Exception;
	
	
	//批量添加角色的挂接的菜单，添加之前通过角色id删除该角色的所有挂接记录
	public boolean addRoleMenuJoins(int roleId,
			List<RoleMenuJoinDto> roleMenuJoins) throws Exception;

}
