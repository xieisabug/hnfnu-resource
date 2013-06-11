package com.hnfnu.zyw.dao.system;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.UserDto;

public interface IUserDao extends IBaseDao<UserDto>{

	//根据任意字段得到一个用户信息
	public UserDto getUser(String hql) throws Exception;
	
}
