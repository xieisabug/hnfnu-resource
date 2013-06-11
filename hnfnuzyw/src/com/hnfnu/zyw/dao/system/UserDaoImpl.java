package com.hnfnu.zyw.dao.system;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.UserDto;

@Repository("userDao")
public class UserDaoImpl extends BaseDao<UserDto> implements IUserDao {

	public UserDto getUser(String hql) throws Exception {
		Query u = this.getSession().createQuery(hql);
		UserDto d = (UserDto) u.uniqueResult();
		return d;
	}

}
