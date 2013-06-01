package com.hnfnu.zyw.dao.system;

import java.util.List;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.UserRoleJoinDto;

public interface IUserRoleJoinDao extends IBaseDao<UserRoleJoinDto> {

	//通过userId批量删除该用户已经挂接的所有角色

	public boolean deleteByUserId(int userId) throws Exception;
	
	//批量添加用户角色挂接记录,在添加之前先删除该用户的角色
	public boolean addUserRoleJoins(int userId,List<UserRoleJoinDto> userRoleJoins) throws Exception;
}
