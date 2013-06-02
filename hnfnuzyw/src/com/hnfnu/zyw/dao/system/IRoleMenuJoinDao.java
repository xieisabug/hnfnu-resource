package com.hnfnu.zyw.dao.system;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.RoleMenuJoinDto;

public interface IRoleMenuJoinDao extends IBaseDao<RoleMenuJoinDto> {

	//通过角色id和菜单id得到一个RoleMenuJoin实体
	
	public RoleMenuJoinDto uniqueLoad(String hql) throws Exception;
	
}
