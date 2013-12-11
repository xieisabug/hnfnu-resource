package com.hnfnu.zyw.service.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IUserDao;
import com.hnfnu.zyw.dto.system.UserDto;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	@Qualifier("userDao")
	public IUserDao userDao;

	public boolean add(UserDto user) {
		try {
			// 老师默认资源币为0
			user.setBalance(0);
			Date today = new Date();
			user.setCreateDate(today);
			user.setLatestLoginDate(today);
			userDao.add(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			userDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(UserDto user) {
		try {
			UserDto u = userDao.get(user.getId());
			user.setPassword(u.getPassword());
			userDao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public UserDto load(int id) {
		try {
			return userDao.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, Object> list() {
		Map<String, Object> userList = new HashMap<String, Object>();

		String hql = "from UserDto";
		List<UserDto> users = null;
		try {
			users = userDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		userList.put("Rows", users);
		userList.put("Total", users.size());
		return userList;
	}

	public boolean updatePwd(int id, String newPassword) {
		// UserDto u = this.load(id);
		// if (u != null) {
		// u.setPassword(newPassword);
		// return this.update(u);
		// }
		try {
			userDao.updatePwd(id, newPassword);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	/**
	 * 检验用户名是否重复
	 * 
	 * @param username
	 * @return
	 */
	public boolean validateUserName(String username) {
		String hql = "from UserDto where username='" + username + "'";
		UserDto u = null;
		try {
			//System.out.println("***************************" + username);
			u = userDao.getUser(hql);
			//System.out.println(u);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (u == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 给用户批量充值资源币
	 */
	public int addUserBalance(int count, String userIds) {
		return userDao.addUserBalance(count, userIds);
	}
}
