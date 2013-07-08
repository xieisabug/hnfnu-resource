package com.hnfnu.zyw.service.system;

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
			userDao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public UserDto load(int id) {
		try {
			return userDao.load(id);
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

}
