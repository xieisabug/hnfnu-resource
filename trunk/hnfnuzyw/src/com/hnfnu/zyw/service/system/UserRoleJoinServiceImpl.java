package com.hnfnu.zyw.service.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.IUserRoleJoinDao;
import com.hnfnu.zyw.dto.system.UserRoleJoinDto;

@Service("userRoleJoinService")
public class UserRoleJoinServiceImpl implements IUserRoleJoinService {

	// ²Ù×÷user_role_join±íµÄdao
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

	/*
	 * public Map<String, Object> list() { Map<String, Object> userRoleJoinList
	 * = new HashMap<String, Object>();
	 * 
	 * String hql = "from UserRoleJoinDto"; List<UserRoleJoinDto> userRoleJoins
	 * = null; try { userRoleJoins = userRoleJoinDao.list(hql); } catch
	 * (Exception e) { e.printStackTrace(); }
	 * 
	 * userRoleJoinList.put("Rows", userRoleJoins);
	 * userRoleJoinList.put("Total", userRoleJoins.size()); return
	 * userRoleJoinList; }
	 */

}
