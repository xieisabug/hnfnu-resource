package com.hnfnu.zyw.service.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IUserRoleJoinDao;
import com.hnfnu.zyw.dto.system.UserRoleJoinDto;

@Service("userRoleJoinService")
public class UserRoleJoinServiceImpl implements IUserRoleJoinService {

	// 操作user_role_join表的dao
	@Autowired
	@Qualifier("userRoleJoinDao")
	public IUserRoleJoinDao userRoleJoinDao;

	public boolean add(UserRoleJoinDto userRoleJoin) {
		try {
			userRoleJoinDao.add(userRoleJoin);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			userRoleJoinDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(UserRoleJoinDto userRoleJoin) {
		try {
			userRoleJoinDao.update(userRoleJoin);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public UserRoleJoinDto load(int id) {
		try {
			return userRoleJoinDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteByUserId(int userId) {
		try {
			return userRoleJoinDao.deleteByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addUserRoleJoins(String userRoleIds) {
		String[] ids = userRoleIds.split(";");
		int userId = Integer.parseInt(ids[0]);
		
		List<UserRoleJoinDto> userRoleJoins = new ArrayList<UserRoleJoinDto>();
		//当该用户没有角色时
		if(ids.length < 2){
			userRoleJoins = null;
		}
		for(int i = 1; i < ids.length;i++){
			UserRoleJoinDto dto = new UserRoleJoinDto(null, userId,Integer.parseInt(ids[i]));
			userRoleJoins.add(dto);
		}
		try {
			return userRoleJoinDao.addUserRoleJoins(userId,userRoleJoins);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
