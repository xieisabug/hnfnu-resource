package com.hnfnu.zyw.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dto.User;

@Repository("userHibernateDao")
public class UserHibernateDao extends IBaseDao implements IUserHibernateDao {

	public void add(User user) throws Exception {
		getSession().save(user);

	}

	public boolean delete(int userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public User query(int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> queryUsers(String userName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(User user, int userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
