package com.hnfnu.zyw.service.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IUserDao;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.dto.system.ValidateMessege;

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

	public ValidateMessege validateUser(UserDto user) {
		String hql = "from UserDto where username='" + user.getUsername() + "'";
		UserDto u = null;
		ValidateMessege messege = new ValidateMessege();
		try {
			u = userDao.getUser(hql);
		} catch (Exception e) {
			e.printStackTrace();
			messege.setResult(false);
			messege.setMessege("登陆失败");
			return messege;
		}
		if(u == null){
			messege.setResult(false);
			messege.setMessege("用户名不存在");
			return messege;
		}else{
			if (u.getPassword().equals(user.getPassword())) {
				messege.setO(u);
				messege.setResult(true);
				messege.setMessege("登陆成功");
				return messege;
			}else{
				messege.setResult(false);
				messege.setMessege("密码不正确");
				return messege;
			}
		}
	}

}
