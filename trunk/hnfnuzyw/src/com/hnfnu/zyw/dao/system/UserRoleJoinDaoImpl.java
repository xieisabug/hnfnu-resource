package com.hnfnu.zyw.dao.system;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.UserRoleJoinDto;

@Repository("userRoleJoinDao")
public class UserRoleJoinDaoImpl extends BaseDao<UserRoleJoinDto> implements
		IUserRoleJoinDao {

}
