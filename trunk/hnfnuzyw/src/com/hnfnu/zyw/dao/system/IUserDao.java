package com.hnfnu.zyw.dao.system;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.UserDto;

public interface IUserDao extends IBaseDao<UserDto>{

	//���������ֶεõ�һ���û���Ϣ
	public UserDto getUser(String hql) throws Exception;
	
}
