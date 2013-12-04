package com.hnfnu.zyw.dao.system;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.UserDto;

public interface IUserDao extends IBaseDao<UserDto>{

	//¸ù¾ÝÈÎÒâ×Ö¶ÎµÃµ½Ò»¸öÓÃ»§ÐÅÏ¢
	public UserDto getUser(String hql) throws Exception;
	
	//ÐÞ¸ÄÃÜÂë
	public void updatePwd(int id,String newPassword ) throws Exception;
	
}
