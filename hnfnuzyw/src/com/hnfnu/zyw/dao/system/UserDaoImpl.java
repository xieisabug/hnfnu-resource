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

	public void updatePwd(int id,String newPassword) throws Exception {
		UserDto userDto =  this.get(id);
		
		userDto.setPassword(newPassword);
		System.out.println(userDto+"userDto");
		this.update(userDto);
	}


}
