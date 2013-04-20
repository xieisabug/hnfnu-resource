package com.hnfnu.zyw.dao;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dto.User;


@Repository("userDao")
public class UserDaoImpl implements IUserDao {

	public void save(User user) {
	System.out.println(user.getName()+user.getUsename());
	}
	
	

}
