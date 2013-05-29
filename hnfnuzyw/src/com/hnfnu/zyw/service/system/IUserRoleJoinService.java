package com.hnfnu.zyw.service.system;

import com.hnfnu.zyw.dto.system.UserRoleJoinDto;

public interface IUserRoleJoinService {

	public boolean add(UserRoleJoinDto userRoleJoin);

	public boolean delete(int id);

	public boolean update(UserRoleJoinDto userRoleJoin);

	public UserRoleJoinDto load(int id);

}
