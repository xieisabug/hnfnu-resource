package com.hnfnu.zyw.service.website;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.website.ILoginDao;
import com.hnfnu.zyw.vo.RoleMenuVo;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {
	@Autowired
	@Qualifier("loginDao")
	public ILoginDao loginDao;

	public List<RoleMenuVo> getRoleMenusByUserId(int userId) {
		String hql = "SELECT * FROM RoleMenuVo WHERE roleId IN (SELECT roleId FROM v_user_role WHERE userId = "
				+ userId + ")";
		List<RoleMenuVo> list;
		try {
			list =  loginDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return list;
	}

}
