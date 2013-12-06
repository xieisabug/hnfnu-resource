package com.hnfnu.zyw.service.system;

import com.hnfnu.zyw.dto.system.UserRoleJoinDto;

public interface IUserRoleJoinService {

	public boolean add(UserRoleJoinDto userRoleJoin);

	public boolean delete(int id);

	public boolean update(UserRoleJoinDto userRoleJoin);

	public UserRoleJoinDto load(int id);

	// 通过userId批量删除该用户已经挂接的所有角色

	public boolean deleteByUserId(int userId);

	// 批量添加用户角色挂接记录
	public boolean addUserRoleJoins(String userRoleIds);

}
