package com.hnfnu.zyw.service.system;

import java.util.Map;

public interface IUserRoleVoService {

	/**
	 * 通过用户id得到该用户已经拥有的角色,和还未拥有的角色，返回Map值。
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> roleByUser(int id);

}
