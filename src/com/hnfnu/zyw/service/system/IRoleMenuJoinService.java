package com.hnfnu.zyw.service.system;

import java.util.List;

public interface IRoleMenuJoinService {

	//根据角色id,得到该角色已挂接的菜单和未挂接的菜单。
	public List<Object> roleMenuInit(int roleId);
	
	//根据前台传来的id字符串，批量存储
	public boolean addRoleMenuJoins(String joinIds);
	
}
