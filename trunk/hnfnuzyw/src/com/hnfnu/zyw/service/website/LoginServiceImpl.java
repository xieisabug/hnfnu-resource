package com.hnfnu.zyw.service.website;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		String hql = "from roleMenuVo where roleId in (select roleId from v_user_role where userId = "
				+ userId + ") order by parentId asc";
		
		List<RoleMenuVo> list;
		try {
			list =  loginDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		Map<String, Object> oneMenu = null;
		// {"id":"4","name":"专题管理","url":"./welcome.html","icon":"./App/Lib/icons/32X32/product_169.gif" },
		List childList = null;
		int parentId = -1;
		for(int i = 0 ; i < list.size();i++){
			RoleMenuVo roleMenu = list.get(i);
			//如果不是同一个父亲就不在同一个list
			if(roleMenu.getParentId() != parentId){
				
			
				
			childList = new ArrayList<RoleMenuVo>();
			}
			oneMenu = new HashMap<String, Object>();
			
			oneMenu.put("id",i);
			oneMenu.put("name",roleMenu.getMenuName());
			oneMenu.put("url",roleMenu.getUrl());
			childList.add(oneMenu);
		}

		return list;
	}


}
